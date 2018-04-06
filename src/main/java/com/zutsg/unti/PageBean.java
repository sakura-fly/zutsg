package com.zutsg.unti;

/**
 * Created by Administrator on 2018/4/5 0005.
 */
public class PageBean {
//   一页的行数
    private int pageSize=10;
//    共几页
    private int pageCount;
//    当前位置
    private int pageIndex=1;
//   总数目
    private int count;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private int page;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



    public static PageBean pageBean(PageBean pageBean){
         pageBean.setPage((pageBean.getPageIndex()-1)*pageBean.getPageSize());
        if(pageBean.getCount()!=0){
            if(pageBean.getCount()%pageBean.getPageSize()==0){
                pageBean.setPageCount(pageBean.getCount()/pageBean.getPageSize());
            }else {
                pageBean.setPageCount((pageBean.getCount()/pageBean.getPageSize())+1);
            }
        }else {
            pageBean.setPageCount(0);
        }

        return pageBean;
    }
}
