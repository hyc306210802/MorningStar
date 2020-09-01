package com.cmbroot.service;

import com.cmbroot.additional.LoanStrategy;
import com.cmbroot.entity.Loan;
import com.cmbroot.entity.PayLoan;
import com.cmbroot.entity.User;

import java.io.*;
import java.util.*;

/***
 * 输入用户以及贷款信息，并计算两种不同方式下的月还款额
 */
public class LoanService {
    private User userInformation(User user) {
        System.out.println("请输入您的性别：M-男、W-女");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("M|W")) {
            System.out.println("请输入M或者W");
            scanner.next();
        }
        String gender = scanner.next();
        if (gender.equals("M")) {
            user.setRetiredYear(50);
        } else if (gender.equals("W")) {
            user.setRetiredYear(60);
        }
        user.setGender(gender);

        System.out.println("请输入您的年龄：");

        while (!scanner.hasNextInt()) {
            System.out.println("请输入数字：");
            scanner.next();
        }
        user.setAge(scanner.nextInt());

        System.out.println("请输入您的身高和体重：（单位：m，kg）");
        while (!scanner.hasNextFloat()) {
            System.out.println("请输出正确的身高数值（例：1.72）");
            scanner.nextFloat();
        }
        user.setHeight(scanner.nextFloat());
        while (!scanner.hasNextFloat()) {
            System.out.println("请输入正确的体重数值：（例：62）");
        }
        user.setWeight(scanner.nextFloat());
        return user;
    }

    private Loan LoanInformation(Loan loan) {
        System.out.println("请输入贷款方式(S-商贷、G-公积金贷款、C-组合贷款)：");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("S|G|C")) {
            System.out.println("请输入正确的贷款方式(S-商贷、G-公积金贷款、C-组合贷款)：");
            scanner.next();
        }
        loan.setLoanMode(scanner.next());

        System.out.println("请输入房贷总额：");

        while (!scanner.hasNextFloat()) {
            System.out.println("请输入贷款总额：");
            scanner.next();
        }
        loan.setLoanTotal(scanner.nextFloat());


        System.out.println("请选择贷款利率和年限：");

        while (!scanner.hasNextDouble()) {
            System.out.println("请输入正确的利率：");
            scanner.next();
        }
        loan.setLoanRate(scanner.nextDouble());

        while (!scanner.hasNextInt()) {
            System.out.println("请输入正确的年份：");
            scanner.next();
        }
        loan.setYear(scanner.nextInt());

        System.out.println("请输入贷款方式(P-等额本金、I-等额本息)：");
        while (!scanner.hasNext("P|I")) {
            System.out.println("P-等额本金、I-等额本息)：");
            scanner.next();
        }
        loan.setPayMethod(scanner.next());

        return loan;
    }

    private void judge(User user, Loan loan) {
        if (loan.getLoanMode().equals("G")) {
            if (loan.getYear() > user.getRetiredYear() - user.getAge()) {
                System.out.println("您的贷款方式为公积金贷款，且贷款年限超出了退休年龄！");
            }
        }
    }

    private void QASystem(User user) throws IOException {
        System.out.println("请选择项目：\n1.个人信息\n2.聊天");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("1|2|")) {
            System.out.println("请输入数字1或2");
            scanner.nextInt();
        }
        Integer num = scanner.nextInt();
        if (num == 1) {
            System.out.println("1.退休时间查询\n2.BMI指数\n3.贷款额度");
            while (!scanner.hasNext("1|2|3")) {
                System.out.println("请输入数字1~3");
                scanner.next();
            }
            num = scanner.nextInt();
            if (num == 1) {
                System.out.format("您今年%d岁，%d岁退休，距离退休还有%d年\n", user.getAge(),
                        user.getAge() + user.getRetiredYear(), user.getRetiredYear());
            } else if (num == 2) {
                Double bmi = user.getHeight() / Math.pow(user.getWeight(), 2);
                System.out.format("您的身高体重比（BMI）为%f\n", bmi);
            } else if (num == 3) {
                Integer loanQuota = user.getRetiredYear() * 10000;
                System.out.format("您的贷款额度为%d\n", loanQuota);
            }
        } else if (num == 2) {
            System.out.println("1.天气\n2.冷笑话\n3.讲故事");
            while (!scanner.hasNext("1|2|3")) {
                System.out.println("请输入数字1~3");
                scanner.next();
            }
            num = scanner.nextInt();
            if (num == 1) {
                System.out.println("今天28℃，晴天，万里无云");
            } else if (num == 2) {
                dataProcess("joke.txt");

            } else if (num == 3) {
                dataProcess("story.txt");
            }
        }
    }

    private void dataProcess(String fileName) throws IOException {
        FileInputStream fis = null;
        BufferedReader reader;
        try {
            fis = new FileInputStream(fileName);
            reader = new BufferedReader(new InputStreamReader(fis));
            List<String> str = new ArrayList<>(Arrays.asList(reader.readLine().trim().split("\n")));
            Integer size = str.size();
            Random random = new Random();

            List<String> strOut = new ArrayList<>
                    (Arrays.asList(str.get(random.nextInt(size)).split("###")));
            for (int i = 0; i < strOut.size(); i++) {
                System.out.println(strOut.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

        public void calculatePayLoan () throws IOException {
            User user = new User();
            userInformation(user);
            Loan loan = new Loan();
            LoanInformation(loan);
            this.judge(user, loan);
            System.out.println("请选择您需要使用的功能：1.房贷计算 2.交互式对话");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt(1 | 2)) {
                System.out.println("请输入数字1或2");
                scanner.nextInt();
            }
            Integer num = scanner.nextInt();
            if(num == 1) {
                PayLoan payLoan = new PayLoan();
                payLoan = new LoanStrategy(loan, payLoan).getLoanCaculator();
                payLoan.outputPayloan(loan);
            }else {
                QASystem(user);
            }
        }

    }


