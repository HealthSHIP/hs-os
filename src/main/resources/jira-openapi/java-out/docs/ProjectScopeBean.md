

# ProjectScopeBean

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Long** | The ID of the project that the option&#39;s behavior applies to. |  [optional]
**attributes** | [**List&lt;AttributesEnum&gt;**](#List&lt;AttributesEnum&gt;) | Defines the behavior of the option in the project.If notSelectable is set, the option cannot be set as the field&#39;s value. This is useful for archiving an option that has previously been selected but shouldn&#39;t be used anymore.If defaultValue is set, the option is selected by default. |  [optional]



## Enum: List&lt;AttributesEnum&gt;

Name | Value
---- | -----
NOTSELECTABLE | &quot;notSelectable&quot;
DEFAULTVALUE | &quot;defaultValue&quot;



