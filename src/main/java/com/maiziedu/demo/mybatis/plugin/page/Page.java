package com.maiziedu.demo.mybatis.plugin.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
	public static final String ORDER_ASC = "asc";
	public static final String ORDER_DESC = "desc";

    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page() {

    }

    private boolean checkFirstFrom = true; //执行count的时候，会找第一个from

	private int pageNo = 1;
    private int pageSize = 5;

	private int totalRecord;
    private int totalPage;
    private List<T> results;

    private String sortColumn;
    private String sortOrder = ORDER_ASC;

    private Map<String, Object> params = new HashMap<String, Object>();//其他的参数我们把它分装成一个Map对象  

    public int getPageNo() {
       return pageNo;
    }

    public void setPageNo(int pageNo) {
       this.pageNo = pageNo;
    }

    public int getPageSize() {
       return pageSize;
    }

    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
    }
    
    public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	
	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

    public int getTotalRecord() {
       return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
        this.setTotalPage(totalPage);

        if(pageNo > totalPage){
            pageNo = 1;
        }

    }

    public int getTotalPage() {
       return totalPage;
    }

    public void setTotalPage(int totalPage) {
       this.totalPage = totalPage;
    }

    public List<T> getResults() {
       return results;
    }

    public void setResults(List<T> results) {
       this.results = results;
    }

    public Map<String, Object> getParams() {
       return params;
    }

    public void setParams(Map<String, Object> params) {
       this.params = params;
    }

    public boolean isCheckFirstFrom() {
        return checkFirstFrom;
    }

    public void setCheckFirstFrom(boolean checkFirstFrom) {
        this.checkFirstFrom = checkFirstFrom;
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
              .append(pageSize).append(", results=").append(results).append(
                     ", totalPage=").append(totalPage).append(
                     ", totalRecord=").append(totalRecord).append("]");
       return builder.toString();
    }
}
