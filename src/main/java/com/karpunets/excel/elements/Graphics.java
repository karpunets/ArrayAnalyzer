package com.karpunets.excel.elements;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import java.util.List;

/**
 * Class Graphics is used for draw graphic in xlsx file.
 *
 * @author Karpunets
 * @since 26.11.2016
 */
public class Graphics {

    private final int col1;
    private final int row1;
    private final int col2;
    private final int row2;

    /**
     * Params determine the size of graphic.
     *
     * @param col1 the column of the first cell.
     * @param row1 the row of the first cell.
     * @param col2 the column of the second cell.
     * @param row2 the row of the second cell.
     */
    public Graphics(int col1, int row1, int col2, int row2) {
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
    }

    /**
     * Method draw draws graphic in object {@link Sheet}.
     *
     * @param listSort list of sorters.
     * @param timeNum number of array are tested.
     */
    public void draw(Sheet sheet, List<String> listSort, int timeNum) {
        Drawing drawing = sheet.createDrawingPatriarch();

        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, col1, row1, col2, row2);

        Chart chart = drawing.createChart(anchor);
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.TOP_RIGHT);

        ScatterChartData data = chart.getChartDataFactory().createScatterChartData();

        ValueAxis bottomAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 1, timeNum));

        for (int i = 1; i <= listSort.size(); i++) {
            ChartDataSource<Number> ys = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(i, i, 1, timeNum));
            data.addSerie(xs, ys).setTitle(listSort.get(i - 1));
        }

        chart.plot(data, bottomAxis, leftAxis);
    }

}
