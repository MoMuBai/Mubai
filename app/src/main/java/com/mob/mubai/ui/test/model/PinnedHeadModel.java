package com.mob.mubai.ui.test.model;

import com.mob.mubai.data.bean.ViewTypeBean;
import com.mob.mubai.ui.test.adapter.MenuViewTypeAdapter;
import com.mob.mubai.ui.test.contract.PinnedHeadContract;
import com.mob.mubai.ui.test.contract.RecyclerContract;

import java.util.ArrayList;
import java.util.List;

/**
 * //////////////////////////////////////////////////////////////////////////////
 * //
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┗┛　  ┗┛　┃
 * //      ┃　　　　　　 ┃
 * //      ┃　　　┻　　　┃               @Author  林志文
 * //      ┃　　　　　　 ┃
 * //      ┗━┓　　　┏━━━┛               @Date  2016/11/25
 * //        ┃　　　┃   神兽保佑
 * //        ┃　　　┃   代码无BUG！      @Desc
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣━━━┛
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 * //
 * /////////////////////////////////////////////////////////////////////////////
 */

public class PinnedHeadModel implements PinnedHeadContract.Model {

        @Override
        public String[] getHeadData() {
                String[] head = new String[]{"热门城市", "A", "B", "C", "D", "F", "H", "J", "K", "L", "G"};
                return head;
        }

        @Override
        public String[][] getData() {
                String[][] data = new String[][]{{"北京", "上海", "杭州", "广州", "深圳", "厦门"},
                          {"安徽1", "安徽2", "安徽3", "安徽4"}, {"北京1", "北京2", "北京3", "北京4", "北京5",},
                          {"重庆1", "重庆2", "重庆3", "重庆4", "重庆5", "重庆6"}, {"大连1", "大连2", "大连3", "大连4"},
                          {"福州1", "福州2", "福州3", "福州4", "福州5"}, {"哈尔滨1", "哈尔滨2", "哈尔滨3", "哈尔滨4", "哈尔滨5", "哈尔滨6"},
                          {"济南1", "济南2", "济南3", "济南4", "济南5"}, {"郑州1", "郑州2", "郑州3", "郑州4", "郑州5", "郑州6"},
                          {"卡尔1", "卡尔2", "卡尔3", "卡尔4", "卡尔5"}, {"兰亭1", "兰亭2", "兰亭3", "兰亭4", "兰亭5"}};
                return data;
        }

        @Override
        public String[] getIndex() {
                String[] index = new String[]{"#", "热门", "A", "B", "C", "D", "F", "H", "J", "K", "L", "G"};
                return index;
        }
}
