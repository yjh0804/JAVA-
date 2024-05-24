package Test4_7;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Test4_7 extends JFrame {
    private List<Route> routes = new ArrayList();

    public Test4_7() {
        this.setTitle("武汉地铁模拟系统");
        final Container c = this.getContentPane();
        c.setLayout(new GridLayout(7, 1));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JLabel tl1 = new JLabel("输入起点站和终点站，返回最短路径");
        JButton tr1 = new JButton("确定");
        JButton tr2 = new JButton("打印路径至标准输出");
        JButton t3 = new JButton("计算路径对应的乘车费用(普通单程票)");
        JButton t4 = new JButton("计算使用武汉通的乘客的票价");
        JButton t5 = new JButton("计算使用日票的乘客的票价");
        final JTextField t11 = new JTextField(10);
        final JTextField t12 = new JTextField(10);
        final Font f = new Font("微软雅黑", 0, 12);
        tl1.setFont(f);
        tr1.setFont(f);
        tr2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        t5.setFont(f);
        tr1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d3 = new JDialog();
                d3.setTitle("最短路径");
                JTextArea a3 = new JTextArea(4, 10);
                String content = "";
                ArrayList<String> best = Test4_7.this.getBestPath(t11.getText(), t12.getText());
               boolean i = false;

                int ix;
                for(ix = 0; ix < best.size() - 1; ++ix) {
                    content = content + " " + (String)best.get(ix) + " " + "->";
                }

                content = content + (String)best.get(ix);
                a3.setText(content);
                a3.setFont(f);
                a3.setLineWrap(true);
                a3.setBackground(c.getBackground());
                a3.setBorder(new EmptyBorder(10, 10, 10, 10));
                a3.setEditable(false);
                d3.add(a3);
                d3.setSize(300, 150);
                d3.setVisible(true);
                d3.setDefaultCloseOperation(2);
                d3.setLocationRelativeTo((Component)null);
            }
        });
        tr2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d4 = new JDialog();
                d4.setTitle("打印最短路径至标准输出");
                JTextArea a4 = new JTextArea(4, 10);
                a4.setText(Test4_7.this.printBestPath(t11.getText(), t12.getText()));
                a4.setFont(f);
                a4.setLineWrap(true);
                a4.setBackground(c.getBackground());
                a4.setBorder(new EmptyBorder(10, 10, 10, 10));
                a4.setEditable(false);
                d4.add(a4);
                d4.setSize(300, 150);
                d4.setVisible(true);
                d4.setDefaultCloseOperation(2);
                d4.setLocationRelativeTo((Component)null);
            }
        });
        t3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d5 = new JDialog();
                d5.setTitle("路径对应的乘车费用(普通单程票)");
                JTextArea a5 = new JTextArea(2, 5);
                a5.setText(Double.valueOf(Test4_7.this.countPath(Test4_7.this.getBestPath(t11.getText(), t12.getText()), "UsualPay")).toString());
                a5.setFont(f);
                a5.setLineWrap(true);
                a5.setBackground(c.getBackground());
                a5.setBorder(new EmptyBorder(10, 10, 10, 10));
                a5.setEditable(false);
                d5.add(a5);
                d5.setSize(200, 100);
                d5.setVisible(true);
                d5.setDefaultCloseOperation(2);
                d5.setLocationRelativeTo((Component)null);
            }
        });
        t4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d6 = new JDialog();
                d6.setTitle("使用武汉通的乘客的票价");
                JTextArea a6 = new JTextArea(2, 5);
                a6.setText(Double.valueOf(Test4_7.this.countPath(Test4_7.this.getBestPath(t11.getText(), t12.getText()), "CardPay")).toString());
                a6.setFont(f);
                a6.setLineWrap(true);
                a6.setBackground(c.getBackground());
                a6.setBorder(new EmptyBorder(10, 10, 10, 10));
                a6.setEditable(false);
                d6.add(a6);
                d6.setSize(200, 100);
                d6.setVisible(true);
                d6.setDefaultCloseOperation(2);
                d6.setLocationRelativeTo((Component)null);
            }
        });
        t5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d7 = new JDialog();
                d7.setTitle("使用日票的乘客的票价");
                JTextArea a7 = new JTextArea(2, 5);
                a7.setText(Double.valueOf(Test4_7.this.countPath(Test4_7.this.getBestPath(t11.getText(), t12.getText()), "RegularPay")).toString());
                a7.setFont(f);
                a7.setLineWrap(true);
                a7.setBackground(c.getBackground());
                a7.setBorder(new EmptyBorder(10, 10, 10, 10));
                a7.setEditable(false);
                d7.add(a7);
                d7.setSize(200, 100);
                d7.setVisible(true);
                d7.setDefaultCloseOperation(2);
                d7.setLocationRelativeTo((Component)null);
            }
        });
        p1.add(tl1);
        p1.add(t11);
        p1.add(t12);
        p1.add(tr1);
        p2.add(tr2);
        p3.add(t3);
        p4.add(t4);
        p5.add(t5);
        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);
        c.add(p5);
        this.setFont(f);
        this.setSize(600, 350);
        this.setVisible(true);
        this.setDefaultCloseOperation(2);
        this.setLocationRelativeTo((Component)null);
    }

    private void readFile() {
        try {
            Scanner s = new Scanner(new File("E:/大作业/subway.txt"));
            int rankLine = 0;

            while(s.hasNext()) {
                String line = s.nextLine();
                if (line.contains("线")) {
                    Route r = new Route();
                    r.setName(line.substring(0, line.indexOf("线") + 1));
                    this.routes.add(r);
                    ++rankLine;
                }

                if (line.contains("---")) {
                    this.setIntervals((Route)this.routes.get(rankLine - 1), line);
                }
            }

            s.close();
        } catch (NullPointerException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            IOException e = var6;
            e.printStackTrace();
        }

    }

    private void setIntervals(Route r, String l) throws IOException {
        String[] s1 = l.split("---");
        String[] s2 = s1[1].split("\t");
        Interval in = new Interval(s1[0], s2[0], Double.valueOf(s2[1]));
        r.getIntevals().add(in);
    }

    private ArrayList<String> getAllRoutes(String stop) {
        ArrayList<String> all = new ArrayList();
        Iterator var4 = this.routes.iterator();

        while(true) {
            while(var4.hasNext()) {
                Route x = (Route)var4.next();
                Iterator var6 = x.getIntevals().iterator();

                while(var6.hasNext()) {
                    Interval i = (Interval)var6.next();
                    if (i.getStops()[0].equals(stop) || i.getStops()[1].equals(stop)) {
                        all.add(x.getName());
                        break;
                    }
                }
            }

            return all;
        }
    }

    private ArrayList<String> getSortedStops(String routeName, String direction) {
        ArrayList<String> stops = new ArrayList();
        String routeEnd = direction.substring(0, direction.indexOf("方向"));
        Iterator var6 = this.routes.iterator();

        while(var6.hasNext()) {
            Route r = (Route)var6.next();
            if (r.getName().equals(routeName)) {
                int i;
                if (((Interval)r.getIntevals().get(0)).getStops()[0].equals(routeEnd)) {
                    for(i = r.getIntevals().size() - 1; i >= 0; --i) {
                        stops.add(((Interval)r.getIntevals().get(i)).getStops()[1]);
                    }

                    stops.add(routeEnd);
                } else if (((Interval)r.getIntevals().get(r.getIntevals().size() - 1)).getStops()[1].equals(routeEnd)) {
                    for(i = 0; i < r.getIntevals().size(); ++i) {
                        stops.add(((Interval)r.getIntevals().get(i)).getStops()[0]);
                    }

                    stops.add(routeEnd);
                }
                break;
            }
        }

        return stops;
    }

    private ArrayList<String> getAllStops() {
        ArrayList<String> all = new ArrayList();
        Iterator var3 = this.routes.iterator();

        while(var3.hasNext()) {
            Route r = (Route)var3.next();
            Iterator var5 = r.getIntevals().iterator();

            while(var5.hasNext()) {
                Interval i = (Interval)var5.next();
                String[] var9;
                int var8 = (var9 = i.getStops()).length;

                for(int var7 = 0; var7 < var8; ++var7) {
                    String s = var9[var7];
                    boolean b = true;

                    for(int j = 0; j < all.size(); ++j) {
                        if (((String)all.get(j)).equals(s)) {
                            b = false;
                        }
                    }

                    if (b) {
                        all.add(s);
                    }
                }
            }
        }

        return all;
    }

    private void initialDistance(double[][] map, ArrayList<String> all, double max) {
        Iterator var6 = this.routes.iterator();

        label64:
        while(var6.hasNext()) {
            Route r = (Route)var6.next();
            Iterator var8 = r.getIntevals().iterator();

            while(true) {
                while(true) {
                    if (!var8.hasNext()) {
                        continue label64;
                    }

                    Interval interval = (Interval)var8.next();

                    for(int i = 0; i < all.size(); ++i) {
                        if (interval.getStops()[0].equals(all.get(i))) {
                            for(int j = 0; j < all.size(); ++j) {
                                if (((String)all.get(j)).equals(interval.getStops()[1])) {
                                    map[i][j] = interval.getDistance();
                                    map[j][i] = interval.getDistance();
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < map.length; ++i) {
            for(int j = 0; j < map.length; ++j) {
                if (map[i][j] == 0.0 && i != j) {
                    map[i][j] = max;
                }
            }
        }

    }

    private ArrayList<String> getBestPath(String start, String end) {
        ArrayList<String> best = new ArrayList();
        ArrayList<String> all = this.getAllStops();
        double max = 1000.0;
        double[][] map = new double[all.size()][all.size()];
        this.initialDistance(map, all, max);
        boolean[] isVisited = new boolean[map.length];
        double[] minDistance = new double[map.length];

        int startIndex;
        for(startIndex = 0; startIndex < map.length; ++startIndex) {
            isVisited[startIndex] = false;
            minDistance[startIndex] = max;
        }

        startIndex = 0;
        int endIndex = 0;

        int i;
        for(i = 0; i < all.size(); ++i) {
            if (((String)all.get(i)).equals(start)) {
                minDistance[i] = 0.0;
                isVisited[i] = true;
                startIndex = i;
            }

            if (((String)all.get(i)).equals(end)) {
                endIndex = i;
            }
        }

        i = map.length;
        int indexNow = startIndex;
        int[] pre = new int[map.length];

        while(i > 0 && indexNow != endIndex) {
            double min = max;

            int j;
            for(j = 0; j < map.length; ++j) {
                if (!isVisited[j] && minDistance[j] < min) {
                    min = minDistance[j];
                    indexNow = j;
                }
            }

            isVisited[indexNow] = true;
            --i;

            for(j = 0; j < map.length; ++j) {
                if (!isVisited[j] && minDistance[indexNow] + map[indexNow][j] < minDistance[j]) {
                    minDistance[j] = minDistance[indexNow] + map[indexNow][j];
                    pre[j] = indexNow;
                }
            }
        }

        this.returnBestRoute(startIndex, endIndex, all, pre, best);
        return best;
    }

    private void returnBestRoute(int startIndex, int endIndex, ArrayList<String> all, int[] pre, ArrayList<String> best) {
        if (endIndex == startIndex) {
            best.add((String)all.get(endIndex));
        } else {
            this.returnBestRoute(startIndex, pre[endIndex], all, pre, best);
            best.add((String)all.get(endIndex));
        }
    }

    private boolean inSameRoute(String s1, String s2) {
        Iterator var4 = this.routes.iterator();

        boolean b1;
        boolean b2;
        do {
            if (!var4.hasNext()) {
                return false;
            }

            Route r = (Route)var4.next();
            b1 = false;
            b2 = false;
            Iterator var8 = r.getIntevals().iterator();

            while(var8.hasNext()) {
                Interval i = (Interval)var8.next();
                String[] var12;
                int var11 = (var12 = i.getStops()).length;

                for(int var10 = 0; var10 < var11; ++var10) {
                    String s = var12[var10];
                    if (s1.equals(s)) {
                        b1 = true;
                    } else if (s2.equals(s)) {
                        b2 = true;
                    }
                }
            }
        } while(!b1 || !b2);

        return true;
    }

    private String getRouteByTwoStops(String s1, String s2) {
        Iterator var4 = this.getAllRoutes(s1).iterator();

        while(var4.hasNext()) {
            String r1 = (String)var4.next();
            Iterator var6 = this.getAllRoutes(s2).iterator();

            while(var6.hasNext()) {
                String r2 = (String)var6.next();
                if (r1.equals(r2)) {
                    return r2;
                }
            }
        }

        return null;
    }

    private String printBestPath(String start, String end) {
        ArrayList<String> path = this.getBestPath(start, end);
        String result = "乘" + this.getRouteByTwoStops((String)path.get(0), (String)path.get(1)) + "[" + start + " , ";

        for(int i = 2; i < path.size(); ++i) {
            if ((!this.inSameRoute((String)path.get(i), (String)path.get(i - 2)) || this.inSameRoute((String)path.get(i), (String)path.get(i - 2)) && !this.getRouteByTwoStops((String)path.get(i), (String)path.get(i - 2)).equals(path.get(i - 2))) && !this.getRouteByTwoStops((String)path.get(i), (String)path.get(i - 1)).equals(this.getRouteByTwoStops((String)path.get(i - 1), (String)path.get(i - 2)))) {
                result = result + (String)path.get(i - 1) + "] , 换乘" + this.getRouteByTwoStops((String)path.get(i - 1), (String)path.get(i)) + "[" + (String)path.get(i - 1) + " , ";
            }
        }

        result = result + end + "]";
        return result;
    }

    private double getDistance(String s1, String s2) {
        Iterator var4 = this.routes.iterator();

        while(var4.hasNext()) {
            Route r = (Route)var4.next();
            Iterator var6 = r.getIntevals().iterator();

            while(var6.hasNext()) {
                Interval i = (Interval)var6.next();
                if (i.getStops()[0].equals(s1) && i.getStops()[1].equals(s2) || i.getStops()[0].equals(s2) && i.getStops()[1].equals(s1)) {
                    return i.getDistance();
                }
            }
        }

        return 0.0;
    }

    private double getDistance(ArrayList<String> path) {
        double dsum = 0.0;

        for(int i = 1; i < path.size(); ++i) {
            dsum += this.getDistance((String)path.get(i), (String)path.get(i - 1));
        }

        return dsum;
    }

    private double countPath(ArrayList<String> path, String type) {
        Pay p = null;
        if (type.equals("RegularPay")) {
            return 0.0;
        } else {
            if (type.equals("UsualPay")) {
                p = new UsualPay(this.getDistance(path));
            } else if (type.equals("CardPay")) {
                p = new CardPay(this.getDistance(path));
            }

            return ((Pay)p).count();
        }
    }

    public static void main(String[] args) {
        Test4_7 t = new Test4_7();
        t.readFile();
    }
}