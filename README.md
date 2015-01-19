# gridLayout
JSF Component for easy usage of CSS grids

## Introduction

gridLayout helps you to layout content in your JSF page using a CSS grid efficiently.  It results in the classic DIV structure used in CSS grids.

```xml
<div class="ui-grid">
    <div class="ui-grid-row">
        <div class="ui-grid-col-4">Col1</div>
        <div class="ui-grid-col-4">Col2</div>
        <div class="ui-grid-col-4">Col2</div>
    </div>
</div>
```

The component isn't tied to any JSF implementation (Mojarra and MyFaces), component library (PrimeFaces, etc ...) or Grid system (Twitter Bootsrap, PrimeFaces CSS Grid, etc ...)


## Configuration

* Download the code from this repository.
* Build the maven project and add the dependency to your application.
```xml
<dependency>
    <groupId>be.rubus.web</groupId>
    <artifactId>gridLayout</artifactId>
    <version>1.0</version>
</dependency>
```
* Define the namespace on top of your xhtml page like : ``xmlns:c4j="http://www.rubus.be/component"```
* Use the component, ``` <c4j:gridLayout columns="2" ... > ```. See the example further on.

## Component configuration

|Attribute | Description |
|----------|-------------|
|columns   | Required. Number of columns in the grid layout.|
|rowClass   | CSS Class which is used on the DIV row.|
|columnClasses | Comma separated list of CSS classes which will be used on the column DIVs |

## Good to know

* Released under the Apache V2 License.
* Compiled with Java 1.5.
* Dependent on JSF 2.0 (Java EE 6), works with any JSF 2.X version.

## Examples

### Basic example

Uses the PrimeFaces CSS grid system and other PrimeFaces components.

```xml
    <div class="ui-grid"> <!-- This should go in the template -->
        <c4j:gridLayout columns="2" rowClass="ui-grid-row" columnClasses="ui-grid-col-2, ui-grid-col-4">
            <p:outputLabel for="firstName" value="First name"/>
            <p:inputText id="firstName"/>

            <p:outputLabel for="lastName" value="Last name"/>
            <p:inputText id="lastName"/>

            <h:panelGroup/>
            <p:commandButton value="save"/>
        </c4j:gridLayout>
    </div>
```

Results in a 2 column layout, which takes only the half of the screen width. CommandButton is aligned under the input fields.

### CSS column classes reused

When each column should have the same CSS class assigned, only one definition is needed. (example uses Bootstrap CSS grid)

```xml
    <div class="container"> <!-- This should go in the template -->
        <c4j:gridLayout columns="3" rowClass="row" columnClasses="col-md-4">
        </c4j:gridLayout>
    </div>
```

Other variations are possible.  For example, when you specify only 2 CSS classes in the attribute `columnClasses` but `3`in the attribute `columns`, then the last column will use the same CSS class as the first one.

### Add custom CSS classes

It is possible to specify more then 1 css class for a column.  These can also be some custom defined CSS classes.

```xml
        <c4j:gridLayout columns="2" rowClass="ui-grid-row" columnClasses="ui-grid-col-2 alignRight, ui-grid-col-4">
      ...
        </c4j:gridLayout>
    </div>
```

The above example will align the labels to the right (In case the alignRight CSS class is defined like `text-align: right;` )

