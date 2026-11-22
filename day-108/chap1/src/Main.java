//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    Date date = new Date(3,3,2008);
    System.out.println(String.valueOf(date.congruence_zeller()));
    System.out.println(date);
    date.prettyPrint();
    System.out.println();
    Person marc = new Person("Marc","Dupuis",2,1,2002);
    System.out.println(marc);

}
