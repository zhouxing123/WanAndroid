package com.yihui.wanandroid.ui.ThirdPage;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/31]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class StanavTypeModel   {


    /**
     * data : [{"articles":[{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1848,"link":"https://developers.google.cn/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515322795000,"superChapterId":0,"superChapterName":"","tags":[],"title":"Google开发者","type":0,"userId":-1,"visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":301,"chapterName":"快速开发","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2217,"link":"https://github.com/jpush/aurora-imui","niceDate":"2018-01-23","origin":"","projectLink":"","publishTime":1516687965000,"superChapterId":0,"superChapterName":"","tags":[],"title":"通用IM UI组件","type":0,"userId":-1,"visible":1,"zan":0}],"cid":301,"name":"快速开发"},{"articles":[{"apkLink":"","author":"小编","chapterId":359,"chapterName":"应用发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2873,"link":"http://dev.360.cn/","niceDate":"2018-04-25","origin":"","projectLink":"","publishTime":1524666305000,"superChapterId":0,"superChapterName":"","tags":[],"title":"360开发者","type":0,"userId":-1,"visible":0,"zan":0}],"cid":359,"name":"应用发布"},{"articles":[{"apkLink":"","author":"小编","chapterId":365,"chapterName":"反馈平台","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2976,"link":"https://tucao.qq.com","niceDate":"2018-06-03","origin":"","projectLink":"","publishTime":1527991466000,"superChapterId":0,"superChapterName":"","tags":[],"title":"一站式解决用户反馈问题","type":0,"userId":-1,"visible":1,"zan":0}],"cid":365,"name":"反馈平台"},{"articles":[{"apkLink":"","author":"小编","chapterId":366,"chapterName":"在线文档","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2977,"link":"https://docs.qq.com","niceDate":"2018-06-03","origin":"","projectLink":"","publishTime":1527991506000,"superChapterId":0,"superChapterName":"","tags":[],"title":"腾讯文档","type":0,"userId":-1,"visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":366,"chapterName":"在线文档","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2978,"link":"https://yuque.com","niceDate":"2018-06-03","origin":"","projectLink":"","publishTime":1527991521000,"superChapterId":0,"superChapterName":"","tags":[],"title":"阿里文档语雀","type":0,"userId":-1,"visible":0,"zan":0}],"cid":366,"name":"在线文档"},{"articles":[{"apkLink":"","author":"小编","chapterId":369,"chapterName":"短视频SDK","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3012,"link":"https://www.upyun.com/products/short-video","niceDate":"2018-06-15","origin":"","projectLink":"","publishTime":1529043871000,"superChapterId":0,"superChapterName":"","tags":[],"title":"又拍云短视频","type":0,"userId":-1,"visible":0,"zan":0}],"cid":369,"name":"短视频SDK"}]
     * errorCode : 0
     * errorMsg :
     */

    private int errorCode;
    private String errorMsg;
    private List<DataBean> data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * articles : [{"apkLink":"","author":"小编","chapterId":272,"chapterName":"常用网站","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1848,"link":"https://developers.google.cn/","niceDate":"2018-01-07","origin":"","projectLink":"","publishTime":1515322795000,"superChapterId":0,"superChapterName":"","tags":[],"title":"Google开发者","type":0,"userId":-1,"visible":0,"zan":0},{"apkLink":"","author":"小编","chapterId":301,"chapterName":"快速开发","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2217,"link":"https://github.com/jpush/aurora-imui","niceDate":"2018-01-23","origin":"","projectLink":"","publishTime":1516687965000,"superChapterId":0,"superChapterName":"","tags":[],"title":"通用IM UI组件","type":0,"userId":-1,"visible":1,"zan":0}]
         * cid : 301
         * name : 快速开发
         */

        private int cid;
        private String name;
        private List<ArticlesBean> articles;
        private boolean isCheck;

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ArticlesBean> getArticles() {
            return articles;
        }

        public void setArticles(List<ArticlesBean> articles) {
            this.articles = articles;
        }

        public static class ArticlesBean {
            /**
             * apkLink :
             * author : 小编
             * chapterId : 272
             * chapterName : 常用网站
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 1848
             * link : https://developers.google.cn/
             * niceDate : 2018-01-07
             * origin :
             * projectLink :
             * publishTime : 1515322795000
             * superChapterId : 0
             * superChapterName :
             * tags : []
             * title : Google开发者
             * type : 0
             * userId : -1
             * visible : 0
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
        }
    }
}
