

# ProjectRole

Details about the roles in a project.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**self** | [**URI**](URI.md) | The URL the project role details. |  [optional] [readonly]
**name** | **String** | The name of the project role. |  [optional]
**id** | **Long** | The ID of the project role. |  [optional] [readonly]
**description** | **String** | The description of the project role. |  [optional] [readonly]
**actors** | [**List&lt;RoleActor&gt;**](RoleActor.md) | The list of users who act in this role. |  [optional] [readonly]
**scope** | [**Scope**](Scope.md) | The scope of the role. Indicated for roles associated with [next-gen projects](https://confluence.atlassian.com/x/loMyO). |  [optional] [readonly]
**translatedName** | **String** | The translated name of the project role. |  [optional]
**admin** | **Boolean** | Whether this role is the admin role for the project. |  [optional] [readonly]
**roleConfigurable** | **Boolean** |  |  [optional]
**_default** | **Boolean** | Whether this role is the default role for the project |  [optional] [readonly]



