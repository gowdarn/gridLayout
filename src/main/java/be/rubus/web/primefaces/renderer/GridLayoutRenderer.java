/*
 * Copyright 2014-2015 Rudy De Busscher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package be.rubus.web.primefaces.renderer;

import be.rubus.web.primefaces.component.GridLayoutComponent;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class GridLayoutRenderer extends Renderer {

    @Override
    public boolean getRendersChildren() {
        return true;
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        GridLayoutComponent gridLayoutComponent = (GridLayoutComponent) component;
        int columns = gridLayoutComponent.getColumns();
        String[] columnClass = determineColumnClasses(gridLayoutComponent, columns);

        List<UIComponent> children = component.getChildren();
        boolean rowStarted = false;
        for (int idx = 0; idx < children.size(); idx++) {
            if (idx % columns == 0) {
                endRow(writer, rowStarted);
                writer.write("<div class='");
                writer.write(gridLayoutComponent.getRowClass());
                writer.write("'>");
                rowStarted = true;
            }
            writeCell(context, writer, children, columnClass, idx, columns);

        }
        endRow(writer, rowStarted);

    }

    private void writeCell(FacesContext context, ResponseWriter writer, List<UIComponent> children, String[] columnClass, int idx,
                           int columns) throws IOException {
        int colIdx = idx % columns;
        writer.write("<div class='");
        writer.write(columnClass[colIdx]);
        writer.write("'>");

        UIComponent child = children.get(idx);
        child.encodeAll(context);

        writer.write("</div>");
    }

    private String[] determineColumnClasses(GridLayoutComponent gridLayoutComponent, int columns) {
        String[] result = new String[columns];
        Arrays.fill(result, "");
        if (gridLayoutComponent.getColumnClasses() != null) {

            String[] temp = gridLayoutComponent.getColumnClasses().split(",");
            int length = temp.length > columns ? columns : temp.length;
            System.arraycopy(temp, 0, result, 0, length);

            if (length < columns) {
                for (int i = length; i < columns; i++) {
                    result[i] = result[i % length];
                }
            }
        }
        return result;
    }

    private void endRow(ResponseWriter writer, boolean rowStarted) throws IOException {
        if (rowStarted) {
            writer.write("</div>");
        }
    }
}
