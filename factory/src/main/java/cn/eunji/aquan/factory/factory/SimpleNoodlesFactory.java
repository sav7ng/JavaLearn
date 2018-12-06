package cn.eunji.aquan.factory.factory;

import cn.eunji.aquan.factory.service.INoodles;
import cn.eunji.aquan.factory.service.Imp.GankouNoodles;
import cn.eunji.aquan.factory.service.Imp.LzNoodles;
import cn.eunji.aquan.factory.service.Imp.PaoNoodles;

/**
 * @Class SimpleNoodlesFactory
 * @Description TODO
 * @Author Aquan
 * @Date 2018.12.6 14:09
 * @Version 1.0
 **/
public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 0;
    public static final int TYPE_PM = 1;
    public static final int TYPE_GK = 2;

    public static INoodles createNoodles(int type) {
        switch(type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PM:
                return new PaoNoodles();
            case TYPE_GK:
            default:
                return new GankouNoodles();
        }
    }

    public static void main(String[] args) {
        INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_LZ);
        noodles.desc();
    }
}
