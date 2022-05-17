# Втора лабораториска вежба по Софтверско инженерство
## Јордан Нетков 203038
### 1.Control Flow Graph
![image](https://user-images.githubusercontent.com/100224466/168858034-2f2ade81-d23c-4391-b0fd-559c09fc1500.png)
### 2.Цикломатска комплексност
Графот има 24 темиња и 31 ребра па за да ја одредиме комплексноста се водиме по формулата: Формула: E - V + 2 ==> 31 - 24 + 2 = 9 Цикломатската комплексност е 9
### 3.Тестови за Every Statement метода
Имам 4 случаи на оваа метода: 
1.Прв тест - list.size()==0 Овде поминувам само 3 statements, односно тие се 1,2 - 3 - 23
2.Втор тест - rootOfN * rootOfN != n Ова значи дека бројот на елементи на листата мора да е број чиј квадратен корен е цел број Овде поминувам 5 statements, тие се 1,2 - 4 - 5 - 6 - 23
3.Трет тест - input list = ["0","0","0","0","0","0","0","0","0"] Овде поминуваат сите statements освен оние за исклучоци и следниве:12,13,14,16,18 и 20 бидејќи нема "#" во листата.
4.Последен тест - input list = [0,#,0,0,0,#,#,0,#]
 Во овој тест поминуваат сите statements освен оние за исклучоци, а тоа е бидејќи листата не е празна и бројот на елементи е 9 чиј што корен е цел број. Со овие тестови се изминати сите statements.
### 4.Тестови за Every Branch метода:
Оваа метода е многу потемелна бидејќи се изминуваат сите можни ребра во графот. Овде ги  користев првите 3 тест методи од Every Statement Методата, но четвртиот тест не беше успешен како што очекував бидејќи не ги опфаќаше останатите гранки, па затоа го променив.
Сите гранки се:
1,2->3,
1,2->4,
3->23,
4->5,
5->6,
5->7,
6->23,
7->8.1,
8.1->8.2,
8.2->9,
8.2->22,
9->10,
9->20,
10->11,
20->21,
11->12,
11->15,
12->13,
12->14,
13->15,
14->15,
15->16,
15->17,
16->17,
17->18,
17->19,
18->19,
19-21,
21->8.3,
8.3->8.2,
22->23
Првиот тест ги измина гранките 1,2->3 и 3->23 бидејќи листата е празна.
 Вториот тест ги измина гранките 1,2->4, 4->5, 5->6 и 6->23 бидејќи внесувам број чиј корен не е цел број.
 Третиот тест ги измина гранките 1,2->4, 4->5, 5->7, 7->8.1, 8.1->8.2, 8.2->9, 9->10, 10->11, 11->15, 15->17, 17->19, 19->21, 21->8.3, 8.3->8.2, 8.2->22, 22->23. Овде бидејќи листата е само "0" без "#", затоа ги изминува само овие гранки.
 Четвртиот тест е променет и затоа ги опфаќа сите гранки освен оние за исклучоци.
 List input = [0,0,0,#,0,#,0,#,#]
 
### 5. Test cases
 ```
  @Test
    void everyStatementAndEveryBranchThreeTestCases(){ //first three equal test cases for every branch and statement methods
        RuntimeException ex = null;
        ex = assertThrows(RuntimeException.class, ()-> SILab2.function(createList()));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));
        System.out.println("First test throws exception if list length is 0 or less");
        ex = assertThrows(RuntimeException.class, ()-> SILab2.function(createList("0","#","#")));
        System.out.println("Second test throws exception if list length is not a perfect square");
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));
        assertEquals(createList("0","0","0","0","0","0","0","0","0"),SILab2.function(createList("0","0","0","0","0","0","0","0","0")));
    }
    @Test
    void everyStatementFourthTestCase(){
        assertEquals(createList("1","#","2","1","2","#","#","2","#"),SILab2.function(createList("0","#","0","0","0","#","#","0","#")));
    }
    @Test
    void everyBranchFourthTestCase(){
        assertEquals(createList("1","0","1","#","3","#","2","#","#"),SILab2.function(createList("0","0","0","#","0","#","0","#","#")));
    }

```
