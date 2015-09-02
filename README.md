# eva
an android orm library

it's a mini orm library, some feature hasn't been supported!
it's come frome http://satyan.github.io/sugar/index.html

some code example:

TestDataBaseHelper helper = new TestDataBaseHelper(this);
    TestTable t1 = new TestTable();
    t1.age = 10;
    t1.name = "hhh";
    helper.save(t1);

    List<TestTable> testTables = new ArrayList<>();
    for (int i = 0 ; i < 10; i++) {
      TestTable t = new TestTable();
      t.name = "tts"+String.valueOf(i);
      t.age = i * i;
      testTables.add(t);
    }
    helper.save(testTables);
    
    AnotherTable table = new AnotherTable();
    table.b1 = false;
    table.f1 = 1.23f;
    table.text1 = "Haha";
    table.i1 = 12;
    helper.save(table);

    AnotherTable at = helper.find(AnotherTable.class, "I1 = ?", new String[]{String.valueOf(12)}).get(0);
    Log.d("cylee",at.b1+" "+at.f1+" "+at.text1+" "+at.i1);
