package com.captainx.learningBackup.设计模式.代理模式;

import jodd.cli.Cli;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/21
 * @Description:代理类
 **/
//1、小明(Person类)刚到上海工作，住在公司宿舍，由于刚入职，工作繁忙没有空余时间，他就委托中山房产 中介公司(Agent类)和他的朋友小张(Friend类)找房子。
//他每天给中介公司或小张打电话，询问有没有合适的房源。他的心理价位是1000元每月。（即小于等于1000的时候，即找到房子）
//中介公司周一至周六工作，每天能找到的一处房源的价格800~3000随机
//小张周日帮他找，每天能找到一处价格约500~4000的房子
//
//编写程序，运行到找到房子。显示当天星期几，显示每天中介或者小张帮他找到房子的价格。


/*
 1、分析当前的程序有哪几个主体，有几个主体就需要创建几个类
 2、有哪些属性
 3、协议的接口写好了
 4、小明要指定谁谁谁做我的代理人
 5、和代理人签约，就是让我的代理人遵守协议
 6、指定具体代理人是谁(创建对象并指定代理人的过程)
 7、让代理人办事（帮我找房子）
    7.1 星期一到星期六中介找房
    7.2 星期天朋友找房
 */

public class ProxyMain {

    public static void main(String[] args) {
        Client ming=new Ming("111111111111");
        Client zhang=new Zhang();
        Agent agent=new Agent();
        agent.addClient(ming);
        agent.addClient(zhang);

        for (int i=0;i<100;i++){
            agent.findHouseAndNotifyClient();
        }

        agent.removeClient(zhang);
        System.out.println("-----------");
        System.out.println("删去客户张");
        System.out.println("-----------");

        for (int i=0;i<100;i++){
            agent.findHouseAndNotifyClient();
        }



    }
}



 interface clientInvoker {

     public void addClient(Client person);


     public void removeClient(Client person);



     public void sendHouseInfo(HouseInfo houseInfo);


}
abstract class Client{
    HouseInfo houseInfo;

    public void setHouseInfo(HouseInfo houseInfo) {
        this.houseInfo = houseInfo;
        printHouseInfo();
    }

    public HouseInfo getHouseInfo(){
        return houseInfo;
    }

    public void printHouseInfo() {
        System.out.println("匹配要求的房屋信息已送达:"+getHouseInfo().toString());
    }

    /**
     * 抽象方法——不同客户的不同房屋需求
     * @param houseInfo
     * @return
     */
    abstract boolean checkHouse(HouseInfo houseInfo);

    public String clientName;

    public String phoneNum;
    }


class Ming extends Client {
    /**
     * 小明需求的房屋价格
     */
    private final int MING_NEED_PRICE = 6000;

    /**
     * 小明需求的客厅数量
     */
    private final int MING_NEED_LIVINGROOM_NUM = 2;

    /**
     * 小明需求的卧室数量
     */
    private final double MING_NEED_BEDROOM_NUM = 3;

    public Ming(String phoneNum) {
        this.clientName="Ming";
        this.phoneNum=phoneNum;
    }


    @Override
    boolean checkHouse(HouseInfo houseInfo) {
        int bedRoomNum = houseInfo.getBedRooms();
        int livingRoomNum = houseInfo.getLivingRooms();
        double rents = houseInfo.getRents();
        if(bedRoomNum == MING_NEED_BEDROOM_NUM && livingRoomNum == MING_NEED_LIVINGROOM_NUM && rents <= MING_NEED_PRICE){
            return true;
        }else {
            return false;
        }

    }
}

class Zhang extends Client{
    /**
     * 小张需求的房屋价格
     */
    private final int ZHANG_NEED_PRICE = 1500;

    public Zhang() {
        this.clientName="Zhang";
        this.phoneNum=phoneNum;
    }

    @Override
    boolean checkHouse(HouseInfo houseInfo) {
        double rents = houseInfo.getRents();
        if(rents <= ZHANG_NEED_PRICE){
            return true;
        }else {
            return false;
        }

    }
}

class Agent implements clientInvoker,HouseFinder{


    private ArrayList<Client> list = new ArrayList<>();

    /**
     * 添加客户
     * @param person
     */
    @Override
    public void addClient(Client person) {
        list.add(person);
    }

    /**
     * 删除客户
     * @param person
     */
    @Override
    public void removeClient(Client person) {
        list.remove(person);
    }

    /**
     * 发送房源信息
     * @param houseInfo
     */
    @Override
    public void sendHouseInfo(HouseInfo houseInfo) {
        for (Client person : list) {
            if ( person.checkHouse(houseInfo)){
                System.out.println("房产经纪人为客户"+person.clientName+"找到了合适的房屋");
                person.setHouseInfo(houseInfo);
            }
        }

    }

    @Override
    public HouseInfo findHouse() {
        return new HouseInfo();
    }

    /**
     * 找房源并通知客户
     */
    public void findHouseAndNotifyClient(){
        HouseInfo house = findHouse();
        System.out.println("房产经纪人找到了:"+house.toString());
        sendHouseInfo(house);

    }
}

/**
 * 找房行为抽象接口
 */
interface HouseFinder{
    HouseInfo findHouse();
}


class HouseInfo{
    int livingRooms;
    int bedRooms;
    int rents;

    HouseInfo(){
        Random random = new Random();
        this.livingRooms= random.nextInt(4);
        this.bedRooms= random.nextInt(5)+2;
        this.rents=random.nextInt(10000);
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "livingRooms=" + livingRooms +
                ", bedRooms=" + bedRooms +
                ", rents=" + rents +
                '}';
    }

    public int getLivingRooms() {
        return livingRooms;
    }

    public void setLivingRooms(int livingRooms) {
        this.livingRooms = livingRooms;
    }

    public int getBedRooms() {
        return bedRooms;
    }

    public void setBedRooms(int bedRooms) {
        this.bedRooms = bedRooms;
    }

    public int getRents() {
        return rents;
    }

    public void setRents(int rents) {
        this.rents = rents;
    }
}