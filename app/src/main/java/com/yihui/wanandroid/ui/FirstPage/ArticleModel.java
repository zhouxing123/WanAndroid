package com.yihui.wanandroid.ui.FirstPage;

import com.yihui.wanandroid.app.BaseModel;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/29]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class ArticleModel  extends BaseModel {


    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"applixy","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":917,"link":"http://www.jianshu.com/p/cc31cda29b79","niceDate":"2016-07-07","origin":"简书","projectLink":"","publishTime":1467891620000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"从Eclipse到AndroidStudio（一）初次启动","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":2,"size":20,"total":35}
     * errorCode : 0
     * errorMsg :
     */


    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"applixy","chapterId":60,"chapterName":"Android Studio相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":917,"link":"http://www.jianshu.com/p/cc31cda29b79","niceDate":"2016-07-07","origin":"简书","projectLink":"","publishTime":1467891620000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"从Eclipse到AndroidStudio（一）初次启动","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 2
         * size : 20
         * total : 35
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * author : applixy
             * chapterId : 60
             * chapterName : Android Studio相关
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 917
             * link : http://www.jianshu.com/p/cc31cda29b79
             * niceDate : 2016-07-07
             * origin : 简书
             * projectLink :
             * publishTime : 1467891620000
             * superChapterId : 60
             * superChapterName : 开发环境
             * tags : []
             * title : 从Eclipse到AndroidStudio（一）初次启动
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }

            public DatasBean(String apkLink, String author, int chapterId, String chapterName, boolean collect, int courseId, String desc, String envelopePic, boolean fresh, int id, String link, String niceDate, String origin, String projectLink, long publishTime, int superChapterId, String superChapterName, String title, int type, int userId, int visible, int zan, List<?> tags) {
                this.apkLink = apkLink;
                this.author = author;
                this.chapterId = chapterId;
                this.chapterName = chapterName;
                this.collect = collect;
                this.courseId = courseId;
                this.desc = desc;
                this.envelopePic = envelopePic;
                this.fresh = fresh;
                this.id = id;
                this.link = link;
                this.niceDate = niceDate;
                this.origin = origin;
                this.projectLink = projectLink;
                this.publishTime = publishTime;
                this.superChapterId = superChapterId;
                this.superChapterName = superChapterName;
                this.title = title;
                this.type = type;
                this.userId = userId;
                this.visible = visible;
                this.zan = zan;
                this.tags = tags;
            }
        }
    }
}
