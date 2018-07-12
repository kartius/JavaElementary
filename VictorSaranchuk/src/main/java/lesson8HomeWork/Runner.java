package lesson8HomeWork;

public class Runner {


    public static void main(String[] args) {

        //Добавил Студентов
        Students std1 = new Students("George", 1);
        Students std2 = new Students("Brian", 1);
        Students std3 = new Students("Nick", 2);
        Students std4 = new Students("Aaron", 2);


        //Создал предметы
        Subjects subj1 = new Subjects("Math");
        Subjects subj2 = new Subjects("Biology");
        Subjects subj3 = new Subjects("Physics");
        Subjects subj4 = new Subjects("Chemistry");

        Subjects subjects = new Subjects();

        //Создал группы для изучения опциональных предметов
        GroupSub gr1 = new GroupSub(subj1.namesubj);
        GroupSub gr2 = new GroupSub(subj2.namesubj);
        GroupSub gr3 = new GroupSub(subj3.namesubj);
        GroupSub gr4 = new GroupSub(subj4.namesubj);


        // Создал ArrayList предметов по уровням
        subjects.subjects1lvl.add(subj1.namesubj);
        subjects.subjects1lvl.add(subj2.namesubj);
        subjects.subjects2lvl.add(subj3.namesubj);
        subjects.subjects2lvl.add(subj4.namesubj);

        // Установил опциональные предметы
        std1.setGroups(gr3, std1);
        std2.setGroups(gr4, std2);
        std2.setGroups(gr1, std2);
        std3.setGroups(gr1, std3);
        std4.setGroups(gr2, std4);

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
        gr1.showGroup();
        gr2.showGroup();
        gr3.showGroup();
        gr4.showGroup();



    }

}
