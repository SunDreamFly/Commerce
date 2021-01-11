package com.example.commerce.bean;

import java.util.List;




public class ShopPingBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":1702,"user_id":5,"session_id":"1","goods_id":1127025,"goods_sn":"1127025","product_id":179,"goods_name":"女式蝶边真丝内裤","market_price":39,"retail_price":39,"number":8,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/b2fe79c872a8a7f647264b5e51bcc802.png"}],"cartTotal":{"goodsCount":8,"goodsAmount":312,"checkedGoodsCount":8,"checkedGoodsAmount":312}}
     */

    private Integer errno;
    private String errmsg;
    private DataDTO data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * cartList : [{"id":1702,"user_id":5,"session_id":"1","goods_id":1127025,"goods_sn":"1127025","product_id":179,"goods_name":"女式蝶边真丝内裤","market_price":39,"retail_price":39,"number":8,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/b2fe79c872a8a7f647264b5e51bcc802.png"}]
         * cartTotal : {"goodsCount":8,"goodsAmount":312,"checkedGoodsCount":8,"checkedGoodsAmount":312}
         */

        private CartTotalDTO cartTotal;
        private List<CartListDTO> cartList;

        public CartTotalDTO getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalDTO cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListDTO> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListDTO> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalDTO {
            /**
             * goodsCount : 8
             * goodsAmount : 312
             * checkedGoodsCount : 8
             * checkedGoodsAmount : 312
             */

            private Integer goodsCount;
            private Integer goodsAmount;
            private Integer checkedGoodsCount;
            private Integer checkedGoodsAmount;

            public Integer getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(Integer goodsCount) {
                this.goodsCount = goodsCount;
            }

            public Integer getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(Integer goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public Integer getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(Integer checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public Integer getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(Integer checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListDTO {
            boolean isChecked = false;

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            /**
             * id : 1702
             * user_id : 5
             * session_id : 1
             * goods_id : 1127025
             * goods_sn : 1127025
             * product_id : 179
             * goods_name : 女式蝶边真丝内裤
             * market_price : 39
             * retail_price : 39
             * number : 8
             * goods_specifition_name_value :
             * goods_specifition_ids :
             * checked : 1
             * list_pic_url : http://yanxuan.nosdn.127.net/b2fe79c872a8a7f647264b5e51bcc802.png
             */

            private Integer id;
            private Integer user_id;
            private String session_id;
            private Integer goods_id;
            private String goods_sn;
            private Integer product_id;
            private String goods_name;
            private double market_price;
            private double retail_price;
            private Integer number;
            private String goods_specifition_name_value;
            private String goods_specifition_ids;
            private Integer checked;
            private String list_pic_url;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getUser_id() {
                return user_id;
            }

            public void setUser_id(Integer user_id) {
                this.user_id = user_id;
            }

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public Integer getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(Integer goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public Integer getProduct_id() {
                return product_id;
            }

            public void setProduct_id(Integer product_id) {
                this.product_id = product_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public double getMarket_price() {
                return market_price;
            }

            public void setMarket_price(Integer market_price) {
                this.market_price = market_price;
            }

            public double getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(Integer retail_price) {
                this.retail_price = retail_price;
            }

            public Integer getNumber() {
                return number;
            }

            public void setNumber(Integer number) {
                this.number = number;
            }

            public String getGoods_specifition_name_value() {
                return goods_specifition_name_value;
            }

            public void setGoods_specifition_name_value(String goods_specifition_name_value) {
                this.goods_specifition_name_value = goods_specifition_name_value;
            }

            public String getGoods_specifition_ids() {
                return goods_specifition_ids;
            }

            public void setGoods_specifition_ids(String goods_specifition_ids) {
                this.goods_specifition_ids = goods_specifition_ids;
            }

            public Integer getChecked() {
                return checked;
            }

            public void setChecked(Integer checked) {
                this.checked = checked;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }
        }
    }
}
