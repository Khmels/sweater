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
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as roles>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@co.page>