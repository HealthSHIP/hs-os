

# VersionMoveBean

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**after** | [**URI**](URI.md) | The URL (self link) of the version after which to place the moved version. Cannot be used with &#x60;position&#x60;. |  [optional]
**position** | [**PositionEnum**](#PositionEnum) | An absolute position in which to place the moved version. Cannot be used with &#x60;after&#x60;. |  [optional]



## Enum: PositionEnum

Name | Value
---- | -----
EARLIER | &quot;Earlier&quot;
LATER | &quot;Later&quot;
FIRST | &quot;First&quot;
LAST | &quot;Last&quot;



