package lesson8HomeWork;

public class Runner {


    public static void main(String[] args) {

        //Добавил Студентов
        Students std1=new Students("George", 1);
        Students std2=new Students("Brian", 1);
        Students std3=new Students("Nick", 2);
        Students std4=new Students("Aaron", 2);


        //Создал предметы
        Subjects subj1=new Subjects("Math");
        Subjects subj2=new Subjects("Biology");
        Subjects subj3=new Subjects("Physics");
        Subjects subj4=new Subjects("Chemistry");

        Subjects subjects=new Subjects();

        //Создал группы для изучения опциональных предметов
        GroupSub gr1=new GroupSub(subj1.namesubj);
        GroupSub gr2=new GroupSub(subj1.namesubj);
        GroupSub gr3=new GroupSub(subj1.namesubj);
        GroupSub gr4=new GroupSub(subj1.namesubj);


        // Создал ArrayList предметов по уровням
        subjects.subjects1lvl.add(subj1.namesubj);
        subjects.subjects1lvl.add(subj2.namesubj);
        subjects.subjects2lvl.add(subj3.namesubj);
        subjects.subjects2lvl.add(subj4.namesubj);

        // Установил опциональные предметы
        std1.setGroups(subj3.namesubj);
        std2.setGroups(subj4.namesubj);
        std2.setGroups(subj1.namesubj);
        std3.setGroups(subj1.namesubj);
        std4.setGroups(subj2.namesubj);

        //Установил Кстомные предметы относителььно уровня
        std1.setCustom(subjects.getSubjectslvl(std1.getLvl()));
        std2.setCustom(subjects.getSubjectslvl(std2.getLvl()));
        std3.setCustom(subjects.getSubjectslvl(std3.getLvl()));
        std4.setCustom(subjects.getSubjectslvl(std4.getLvl()));

        //Показать предмметы по студентам
        std1.showSubjects();
        std2.showSubjects();
        std3.showSubjects();
        std4.showSubjects();

        // Вывожу в коснсоль инфо о группах со списком студентов
        System.out.println(gr1.namegr);
        System.out.println(gr2.namegr);
        System.out.println(gr3.namegr);
        System.out.println(gr4.namegr);
    }

}
