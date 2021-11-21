<#import "parts/common.ftlh" as co>

<@co.page>
List of users

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody></tbody>
<#list users as user>

</#list>
</table>
</@co.page>