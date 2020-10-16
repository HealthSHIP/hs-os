

# JiraExpressionsComplexityBean

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**steps** | [**JiraExpressionsComplexityValueBean**](JiraExpressionsComplexityValueBean.md) | The number of steps it took to evaluate the expression. |  [optional]
**expensiveOperations** | [**JiraExpressionsComplexityValueBean**](JiraExpressionsComplexityValueBean.md) | The number of expensive operations executed while evaluating the expression. Expensive operations are those that load additional data, such as entity properties, comments, or custom fields. |  [optional]
**beans** | [**JiraExpressionsComplexityValueBean**](JiraExpressionsComplexityValueBean.md) | The number of Jira REST API beans returned in the response. |  [optional]
**primitiveValues** | [**JiraExpressionsComplexityValueBean**](JiraExpressionsComplexityValueBean.md) | The number of primitive values returned in the response. |  [optional]



