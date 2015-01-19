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
package be.rubus.web.primefaces.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 *
 */
@FacesComponent("rubus.GridLayout")
public class GridLayoutComponent extends UIComponentBase {
    @Override
    public String getFamily() {
        return "rubus";
    }

    enum PropertyKeys {
        columns, columnClasses, rowClass
    }

    // JSF Configuration
    public GridLayoutComponent() {
        setRendererType("rubus.GridLayoutRenderer");
        setRowClass("");
        setColumnClasses("");
    }

    public Integer getColumns() {
        return (Integer) getStateHelper().eval(PropertyKeys.columns);
    }

    public void setColumns(Integer columns) {
        getStateHelper().put(PropertyKeys.columns, columns);
    }

    public String getColumnClasses() {
        return (String) getStateHelper().eval(PropertyKeys.columnClasses);
    }

    public void setColumnClasses(String columnClasses) {
        getStateHelper().put(PropertyKeys.columnClasses, columnClasses);
    }

    public String getRowClass() {
        return (String) getStateHelper().eval(PropertyKeys.rowClass);
    }


    public void setRowClass(String rowClass) {
        getStateHelper().put(PropertyKeys.rowClass, rowClass);
    }

}

