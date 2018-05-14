package com.nsfc.practice.tuning;

/**
 * 对象分析
 * 其大小为：
 * 空对象大小(8byte)
 *          +int大小(4byte)
 *          +Boolean大小(1byte)
 *          +空Object引用的大小(4byte)=17byte。
 * 但是因为Java在对对象内存分配时都是以8的整数倍来分，因此大于17byte的最接近8的整数倍的是24，
 * 因此此对象的大小为24byte。
 *
 * 后端程序建议启用 并行处理器
 * 前端程序建议启用 并发处理器
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/14
 */
public class NewObject {

    int count;

    boolean flag;

    Object object;
}
