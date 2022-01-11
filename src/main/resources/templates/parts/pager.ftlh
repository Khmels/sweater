<#macro pager url page>
    <#if page.getTotalPages() gt 7>
        <#assign
            totalPages = page.getTotalPages()
            pageNumer = page.getNumber()+1

            head = (pageNumer gt 3)?then([1, -1], [1, 2, 3])
            tail = (pageNumer < (totalPages-2))?then([-1, totalPages], [totalPages-2, totalPages-1, totalPages])
            bodyBefore = (pageNumer >3 && pageNumer < totalPages - 1)?then([pageNumer-1], [])
            bodyAfter = (pageNumer > 2 && pageNumer < totalPages - 2)?then([pageNumer+1], [])

            body = head + bodyBefore + (pageNumer > 3 && pageNumer < totalPages - 2)?then([pageNumer],[]) + bodyAfter + tail
        >
    <#else>
        <#assign body = 1..page.getTotalPages()>
    </#if>
    <div class="container mt-3">
        <div class="row">
        <ul class="pagination col justify-content-center">
            <li class="page-item disabled">
                <a class="page-link" href="#">Pages</a>
            </li>
            <#list body as p>
                <#if (p-1) == page.getNumber()>
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${p}</a>
                    </li>
                <#elseif p == -1>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">...</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${p-1}&size=${page.getSize()}" tabindex="-1">${p}</a>
                    </li>
                </#if>
            </#list>
        </ul>

        <ul class="pagination col justify-content-center">
            <li class="page-item disabled">
                <a class="page-link" href="#">Elements on page</a>
            </li>
            <#list [5,10,25,50] as c>
                <#if c == page.getSize()>
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${c}</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a>
                    </li>
                </#if>
            </#list>
        </ul>
        </div>
    </div>
</#macro>