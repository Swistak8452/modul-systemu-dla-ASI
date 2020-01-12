ALTER TABLE `notification_history`
    ADD UNIQUE `unique_index` (`fk_notification`, `change_number`);
ALTER TABLE `user`
    ADD UNIQUE `unique_index` (`email`);
ALTER TABLE `task_history`
    ADD UNIQUE `unique_index` (`fk_task`, `change_number`);


INSERT INTO priority(id, name)
VALUES (1, 'niski'),
       (2, 'średni'),
       (3, 'wysoki'),
       (4, 'krytyczny'),
       (5, 'blokada');


INSERT INTO status(id, name)
VALUES (1, 'zgłoszone'),
       (2, 'przypisane'),
       (3, 'w toku'),
       (4, 'zakończone'),
       (5, 'odrzucone'),
       (6, 'zrealizowane');


INSERT INTO type(id, name)
VALUES (1, 'Realizacja szkolenia.'),
       (2, 'Przygotowanie dokumentacji ochrony danych osobowych.'),
       (3, 'Przeprowadzenie okresowych sprawdzeń.'),
       (4, 'Przeprowadzania procesu analizy ryzyka.'),
       (5, 'Zapewnienie awaryjnego źródła zasilania.'),
       (6, 'Naprawa urządzeń komputerowych.'),
       (7, 'Utylizacja urządzeń komputerowych.'),
       (8, 'Konserwacja systemów informatycznych.'),
       (9, 'Zabezpieczenie systemów.'),
       (10, 'Wprowadzenie zmian w przepisach.'),
       (11, 'Zabezpieczenie pomieszczeń.'),
       (12, 'Odebranie uprawnień.'),
       (13, 'Inne.');


INSERT INTO user(id, first_name, last_name, function, email)
VALUES (1, 'Jan', 'Kowalski', 'pracownik', 'jkowalski@firma.pl'),
       (2, 'Janusz', 'Patyk', 'pracownik', 'jpatyk@firma.pl'),
       (3, 'Kamil', 'Zając', 'kierownik', 'kzajac@firma.pl'),
       (4, 'Artur', 'Dębski', 'pracownik', 'adebski@firma.pl'),
       (5, 'Mariusz', 'Byciński', 'pracownik', 'mbycinski@firma.pl'),
       (6, 'Waldemar', 'Tymiński', 'administrator', 'wtyminski@firma.pl');


INSERT INTO notification(id, archived, name, date, description)
VALUES
(1, false, 'Zagubienie laptopa', '2019-07-16 15:17:19', 'Dnia 16 lipca 2019r pracownik Jan
Kowalski jadąc metrem do pracy zapomniał zabrać z pociągu torby z laptopem. Po skontaktowaniu się z odpowiednimi
służbami laptop nie odnalazł się. Prawdopodobnieosoba postronna go zabrała i dane zawarte na dysku zawierały dane
osobowe klientów. Dysk był zaszyfrowany, więc osoba nieznająca hasła nie ma do niego dostępu. Należy wydać
pracownikowi nowy sprzęt, który będzie spełniał wymagania bezpieczeństwa.'),
(2, false,'Awaria dysku', '2019-08-10 10:28:02', 'Dnia 10.08.2019r pracownik zgłosił
awarię dysku w komputerze. Dysk musi zostać zabezpieczony i zutylizowany pod nadzorem. Na dysku znajdują się
dane osobowe klientów. NAleży również wydać nowy dysk pracownikowi i go zabezpieczyć.'),
(3, false,'Awaria systemu', '2019-08-13 13:00:51', 'Dnia 13.08.2019r od ok. godziny 10:15
do godziny 12:30 system odpowiedzialny za przechowywanie danych osobowych naszych klientów był niedostępny z powodu awarii.'),
(4, false,'Utrata hasła do dysku', '2019-10-02 13:38:05', 'Dnia 02.10.2019r pracownik zgłosił
informację o zapomnieniu hasła do zaszyfrowanego dysku. Niestety to uniemożliwia pracownikowi pracę i dysk musi zostać
wymieniony na nowy. Na dysku znajdują się dane wrażliwe w tym dane osobowe pracowników. Stary dysk należy odpowiednio
zutylizować/zarchiwizować, a pracownikowi należy wydać nowy zabezpieczony dysk do pracy.'),
(5, false,'Kradzież danych', '2019-12-23 16:55:47', 'Dnia 23.12.2019r klient Aleksander
Głowacki poinformował nas, że jego dane osobowe, które były nam udostępnione zostały wykorzystane przez osobę trzecią.');


INSERT INTO notification_history(id, previous_archived, new_archived, fk_notification, fk_edited_by, change_number, previous_name, new_name,
                                 previous_date, new_date, previous_description, new_description)
VALUES (1, false, false, 1, 3, 0, null, 'Zagubienie laptopa',
        null, '2019-07-16 15:17:19',
        null, 'Dnia 16 lipca 2019r pracownik Jan
Kowalski jadąc metrem do pracy zapomniał zabrać z pociągu torby z laptopem. Po skontaktowaniu się z odpowiednimi
służbami laptop nie odnalazł się. Prawdopodobnieosoba postronna go zabrała i dane zawarte na dysku zawierały dane
osobowe klientów. Dysk był zaszyfrowany, więc osoba nieznająca hasła nie ma do niego dostępu. Należy wydać
pracownikowi nowy sprzęt, który będzie spełniał wymagania bezpieczeństwa.'),
       (2, false, false,2, 3, 0, null, 'Awaria dysku',
        null, '2019-08-10 10:28:02', null, 'Dnia 10.08.2019r pracownik zgłosił
awarię dysku w komputerze. Dysk musi zostać zabezpieczony i zutylizowany pod nadzorem. Na dysku znajdują się
dane osobowe klientów. Należy również wydać nowy dysk pracownikowi i go zabezpieczyć.'),
       (3, false, false,3, 3, 0, null, 'Awaria systemu',
        null, '2019-08-13 13:00:51', null, 'Dnia 13.08.2019r od ok.
godziny 10:15 do godziny 12:30 system odpowiedzialny za przechowywanie danych osobowych naszych klientów był
niedostępny z powodu awarii.'),
       (4, false, false,4, 3, 0, null, 'Utrata hasła do dysku',
        null, '2019-10-02 13:38:05', null, 'Dnia 02.10.2019r pracownik zgłosił
informację o zapomnieniu hasła do zaszyfrowanego dysku. Niestety to uniemożliwia pracownikowi pracę i dysk musi zostać
wymieniony na nowy. Na dysku znajdują się dane wrażliwe w tym dane osobowe pracowników. Stary dysk należy odpowiednio
zutylizować/zarchiwizować, a pracownikowi należy wydać nowy zabezpieczony dysk do pracy.'),
       (5, false, false,5, 3, 0, null, 'Kradzież danych',
        null, '2019-12-23 16:55:47', null, 'Dnia 23.12.2019r klient Aleksander
Głowacki poinformował nas, że jego dane osobowe, które były nam udostępnione zostały wykorzystane przez osobę trzecią.');


INSERT INTO task(id, name, description, fk_assigned_person, fk_type, fk_status, fk_priority, fk_related_notification, deadline, archived)
VALUES (1, 'Raport dot. zagubienia laptopa', 'Należy rozpoznać sytuację i stworzyć raport dotyczący
zagubienia laptopa. Raport musi zostać utworzony i przekazany dla Inspektora Danych Osobowych.',
        6, 13, 2, 4, 1, '2019-07-20 00:00:00', false),
       (2, 'Sprawdzenie zabezpieczeń', 'W ramach zadania należy upenić się,
że nikt nie logował się do systemów z zagubionego laptopa.', 6, 9, 2,
        4, 1, '2019-07-20 00:00:00', false),
       (3, 'Odebranie uprawnień', 'Należy usunąć dostępy i wszelkie konta, które były wykorzystywane
na zagubionym sprzęcie, w taki sposób, aby nikt nieupoważniony nie miał dostępu do wrażliwych danych.',
        6, 12, 2, 4, 1, '2019-07-20 00:00:00', false),
       (4, 'Utylizacja sprzętu', 'Należy zutylizować zepsuty dysk', 6,
        7, 2, 1, 2, '2019-08-15 00:00:00', false),
       (5, 'Usunięcie awarii systemu',
        'W ramach zadania należy uruchomić aplikację.',
        6, 8, 2, 3, 3, '2019-08-20 00:00:00', false),
       (6, 'Zweryfikowanie zabezpieczeń systemu', 'W ramach zadania należy sprawdzić,
czy po awarii systemu wszystkie zabezpieczenia działają.',
        6, 9, 2, 2, 3, '2019-08-20 00:00:00', false),
       (7, 'Utylizacja sprzętu', 'Należy zutylizować dysk do którego nie ma dostępu', 6,
        7, 2, 1, 4, '2019-10-10 00:00:00', false),
       (8, 'Zabezpieczenie nowego dysku', 'W ramach zadania należy wydać nowy, zabezpieczonyu
dysk dla pracownika.', 6, 13, 2, 1, 4, '2019-10-10 00:00:00', false),
       (9, 'Sprawdzenie systemów', 'W ramach zadania należy sprawdzić w jaki sposób
dane klientów zostały udostępnione osobom nieuprawnionym.',
        6, 3, 2, 4, 5, '2019-12-30 00:00:00', false),
       (10, 'Ponowna analiza ryzyka', 'Należy ponownie zastanowić się nad ryzykiem utraty
danych osobowych.', 6, 4, 2, 4, 5, '2019-12-30 00:00:00', false),
       (11, 'Zwiększenie zabezpieczeń', 'Należy jak najszybciej wprowadzić nowe zabezpieczenia
systemów.', 6, 9, 2, 4, 5, '2019-12-30 00:00:00', false),
       (12, 'Zmiany w przepisach wewnętrznych', 'Należy dostosować politykę
firmy do nowych ustaleń związanych z bezpieczeństwem danych.',
        6, 10, 2, 4, 5, '2019-12-30 00:00:00', false),
       (13, 'Raport dot. kradzieży danych', 'W ramach zadania
należy utworzyć raport dla inspektora danych osobowych z wyjaśnieniami,
dlaczego dane osobowe dostały się w niepowołane ręce i jakie kroki poczyniliśmy.',
        6, 13, 2, 4, 5, '2019-12-30 00:00:00', false);


INSERT INTO task_history(id, fk_task, fk_edited_by_user, change_number, fk_previous_assigned_user,
                         fk_new_assigned_user, previous_name, new_name, previous_deadline, new_deadline,
                         previous_archived, new_archived,
                         fk_previous_type, fk_new_type, fk_previous_status, fk_new_status,
                         fk_previous_priority, fk_new_priority, previous_description, new_description,
                         fk_previous_related_notification, fk_new_related_notification, change_date_time)
VALUES (1, 1, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 1),
        null,(SELECT name FROM task WHERE task.id = 1),
        null, (SELECT deadline FROM task WHERE task.id = 1),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 1),
        null,(SELECT fk_status FROM task WHERE task.id = 1),
        null,(SELECT fk_priority FROM task WHERE task.id = 1),
        null,(SELECT description FROM task WHERE task.id = 1),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 1),
        '2019-07-16 16:12:25'),
       (2, 2, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 2),
        null,(SELECT name FROM task WHERE task.id = 2),
        null, (SELECT deadline FROM task WHERE task.id = 2),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 2),
        null,(SELECT fk_status FROM task WHERE task.id = 2),
        null,(SELECT fk_priority FROM task WHERE task.id = 2),
        null,(SELECT description FROM task WHERE task.id = 2),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 2),
        '2019-07-16 16:14:53'),
       (3, 3, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 3),
        null,(SELECT name FROM task WHERE task.id = 3),
        null, (SELECT deadline FROM task WHERE task.id = 3),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 3),
        null,(SELECT fk_status FROM task WHERE task.id = 3),
        null,(SELECT fk_priority FROM task WHERE task.id = 3),
        null,(SELECT description FROM task WHERE task.id = 3),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 3),
        '2019-07-16 16:17:18'),
       (4, 4, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 4),
        null,(SELECT name FROM task WHERE task.id = 4),
        null, (SELECT deadline FROM task WHERE task.id = 4),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 4),
        null,(SELECT fk_status FROM task WHERE task.id = 4),
        null,(SELECT fk_priority FROM task WHERE task.id = 4),
        null,(SELECT description FROM task WHERE task.id = 4),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 4),
        '2019-08-10 10:35:08'),
       (5, 5, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 5),
        null,(SELECT name FROM task WHERE task.id = 5),
        null, (SELECT deadline FROM task WHERE task.id = 5),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 5),
        null,(SELECT fk_status FROM task WHERE task.id = 5),
        null,(SELECT fk_priority FROM task WHERE task.id = 5),
        null,(SELECT description FROM task WHERE task.id = 5),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 5),
        '2019-08-13 13:12:31'),
       (6, 6, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 6),
        null,(SELECT name FROM task WHERE task.id = 6),
        null, (SELECT deadline FROM task WHERE task.id = 6),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 6),
        null,(SELECT fk_status FROM task WHERE task.id = 6),
        null,(SELECT fk_priority FROM task WHERE task.id = 6),
        null,(SELECT description FROM task WHERE task.id = 6),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 6),
        '2019-08-13 13:17:03'),
       (7, 7, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 7),
        null,(SELECT name FROM task WHERE task.id = 7),
        null, (SELECT deadline FROM task WHERE task.id = 7),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 7),
        null,(SELECT fk_status FROM task WHERE task.id = 7),
        null,(SELECT fk_priority FROM task WHERE task.id = 7),
        null,(SELECT description FROM task WHERE task.id = 7),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 7),
        '2019-10-02 13:50:15'),
       (8, 8, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 8),
        null,(SELECT name FROM task WHERE task.id = 8),
        null, (SELECT deadline FROM task WHERE task.id = 8),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 8),
        null,(SELECT fk_status FROM task WHERE task.id = 8),
        null,(SELECT fk_priority FROM task WHERE task.id = 8),
        null,(SELECT description FROM task WHERE task.id = 8),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 8),
        '2019-10-02 13:55:01'),
       (9, 9, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 9),
        null,(SELECT name FROM task WHERE task.id = 9),
        null, (SELECT deadline FROM task WHERE task.id = 9),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 9),
        null,(SELECT fk_status FROM task WHERE task.id = 9),
        null,(SELECT fk_priority FROM task WHERE task.id = 9),
        null,(SELECT description FROM task WHERE task.id = 9),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 9),
        '2019-12-23 17:23:11'),
       (10, 10, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 10),
        null,(SELECT name FROM task WHERE task.id = 10),
        null, (SELECT deadline FROM task WHERE task.id = 10),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 10),
        null,(SELECT fk_status FROM task WHERE task.id = 10),
        null,(SELECT fk_priority FROM task WHERE task.id = 10),
        null,(SELECT description FROM task WHERE task.id = 10),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 10),
        '2019-12-23 17:28:01'),
       (11, 11, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 11),
        null,(SELECT name FROM task WHERE task.id = 11),
        null, (SELECT deadline FROM task WHERE task.id = 11),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 11),
        null,(SELECT fk_status FROM task WHERE task.id = 11),
        null,(SELECT fk_priority FROM task WHERE task.id = 11),
        null,(SELECT description FROM task WHERE task.id = 11),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 11),
        '2019-12-23 17:32:46'),
       (12, 12, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 12),
        null,(SELECT name FROM task WHERE task.id = 12),
        null, (SELECT deadline FROM task WHERE task.id = 12),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 12),
        null,(SELECT fk_status FROM task WHERE task.id = 12),
        null,(SELECT fk_priority FROM task WHERE task.id = 12),
        null,(SELECT description FROM task WHERE task.id = 12),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 12),
        '2019-12-23 17:35:34'),
       (13, 13, 6, 0,
        null,(SELECT fk_assigned_person FROM task WHERE task.id = 13),
        null,(SELECT name FROM task WHERE task.id = 13),
        null, (SELECT deadline FROM task WHERE task.id = 13),
        false, (SELECT archived FROM task WHERE task.id = 1),
        null, (SELECT fk_type FROM task WHERE task.id = 13),
        null,(SELECT fk_status FROM task WHERE task.id = 13),
        null,(SELECT fk_priority FROM task WHERE task.id = 13),
        null,(SELECT description FROM task WHERE task.id = 13),
        null,(SELECT fk_related_notification FROM task WHERE task.id = 13),
        '2019-12-23 17:40:13');
