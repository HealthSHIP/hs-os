

# WorkflowTransitionRulesUpdateErrorDetails

Details of any errors encountered while updating workflow transition rules for a workflow.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**workflowId** | [**WorkflowId**](WorkflowId.md) |  |  [optional]
**ruleUpdateErrors** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) | A list of transition rule update errors, indexed by the transition rule ID. Any transition rule that appears here wasn&#39;t updated. | 
**updateErrors** | **List&lt;String&gt;** | The list of errors that specify why the workflow update failed. The workflow was not updated if the list contains any entries. |  [optional]



