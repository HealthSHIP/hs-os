

# PageBeanString

A page of items.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**self** | [**URI**](URI.md) | The URL of the page. |  [optional] [readonly]
**nextPage** | [**URI**](URI.md) | If there is another page of results, the URL of the next page. |  [optional] [readonly]
**maxResults** | **Integer** | The maximum number of items that could be returned. |  [optional] [readonly]
**startAt** | **Long** | The index of the first item returned. |  [optional] [readonly]
**total** | **Long** | The number of items returned. |  [optional] [readonly]
**isLast** | **Boolean** | Whether this is the last page. |  [optional] [readonly]
**values** | **List&lt;String&gt;** | The list of items. |  [optional] [readonly]



