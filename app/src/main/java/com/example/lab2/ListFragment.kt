package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.lab2.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private val adapter = FilmAdapter{
        showMore(it)
    }

    private val filmsList = listOf(
        FilmModel("На голці",1996 ,R.drawable.trainsp, "Фільм британського режисера Денні Бойла" +
                ", знятий за однойменним романом Ірвіна Уелша про пригоди 4 друзів та героїнову залежність," +
                " що підводить їх до останньої межі."),
        FilmModel("Особлива думка", 2002, R.drawable.minor_rep, "2054 рік, Вашингтон." +
                " Джон Андертон — капітан поліції, командир підрозділу профілактики злочинів «Precrime»," +
                " завдяки якому число вбивств вдалося звести до нуля. Троє провидців «прови», що перебувають в ізоляції, бачать злочини," +
                " які будуть здійснені в найближчому майбутньому. Але одного дня прови бачать вбивство невідомого чоловіка самим Джоном і ось тут і починається найцікавіше..."),
        FilmModel("Вовк з Уолл-стріт", 2013, R.drawable.wold_wall, "1987 рік. Джордан Белфорт стає брокером в успішному" +
                " інвестиційному банку. Однак, незабаром банк закривається і за порадою дружини Джордан влаштовується на роботу в невеликий" +
                " заклад, що займається дрібними акціями. Він знайомиться з сусідом Донні, торговцем, який відразу знаходить" +
                " спільну мову з Джорданом і вирішує відкрити з ним власну фірму Stratton Oakmont. Та настає момент," +
                " коли швидким збагаченням Белфорта починає цікавитися агент ФБР..."),
        FilmModel("Інтерстеллар", 2014, R.drawable.interst, "Події фільму починаються в недалекому майбутньому" +
                " — Земля вже не в змозі підтримувати людство, пилові бурі винищують ґрунти, відбувається регрес сучасного суспільства" +
                " до аграрного. Купер колишній льотчик-випробувач NASA і інженер, повертається на ферму до своєї сім'ї: сина Тома," +
                " 10-річної дочки Мерфі та батька його померлої дружини Дональда. Але все змінюється і він раптово стає одним" +
                " з тих хто врятує людство..."),
        FilmModel("Постріл в безодню", 2017, R.drawable.shot_caller_poster, "Джейкоб — успішний біржовий брокер," +
                " який живе зі своєю дружиною Кетрін і сином Джошуа в Каліфорнії. Через неуважність, Джейкоб ненавмисно їде" +
                " на червоне світло, що спричиняє зіткнення; його найкращий друг Том загинув. Джейкоб засуджений до 16 місяців" +
                " за домовленістю про визнання вини та відправлений у Каліфорнійську колонію для чоловіків у Чино," +
                " де він зміниться до невпізнання..."),
        FilmModel("Початок", 2010, R.drawable.incep, "Кінофільм «Початок» розкриває суворий і насичений брехнею" +
                " та жадібністю світ промислового шпигунства, де ціна ідеї чи навіть думки може бути дуже високою. Один з" +
                "найталановитіших злодіїв, Кобб, може запропонувати замовнику те, що комусь може здатися безглуздим, він" +
                " може викрасти ідею з підсвідомості людини. Але що б це зробити розуму доведеться проникнути в саму підсвідомість," +
                " пройшовши шлях від самого початку народження думки, яка і привела до дорогої ідеї. "),
        FilmModel("Адвокат Диявола", 1997, R.drawable.devils, "У Нью-Йорк на запрошення голови" +
                " великого юридичного концерну прибуває молодий адвокат Кевін Ломакс. До цього він був відомий тим, що" +
                " захищав виключно негідників і до того ж не програв жодного процесу. На новому місці роботи він цілком щасливий," +
                " він живе в розкішній квартирі з дружиною, що любить, його оточують цікаві люди."),
        FilmModel("21", 2008, R.drawable.blackj, "Бен Кемпбелл – сором'язливий відмінник з Массачусетського" +
                " технологічного університету. Йому потрібні великі гроші, щоб оплачувати дороге навчання. Бена несподівано" +
                " приймають до групи талановитих студентів університету, які таємно від усіх щовихідних вирушають до Лас-Вегасу." +
                " Озброївшись підробленими документами та якоюсь загадковою формулою, хлопцям супроводжує удача, допомагаючи" +
                " обігравати казино. Під керівництвом неординарного викладача математики Міккі Роси"),
        FilmModel("Американський психопат", 2000, R.drawable.amer, "Вдень він нічим не відрізняється" +
                " від оточуючих, і в натовпі ви не звернете на нього уваги. Але вночі цей вихований громадянин" +
                " перетворюється на витонченого вбивцю, який тероризує спляче місто."),
        FilmModel("1+1", 2011, R.drawable.intouch, "Постраждавши внаслідок нещасного випадку," +
                " багатий аристократ Філіпп наймає в помічники людину, яка найменше підходить для цієї роботи, — молодого" +
                " жителя передмістя Дрісса, який щойно звільнився з в'язниці. Незважаючи на те, що Філіп прикутий" +
                " до інвалідного крісла, Дрісс вдається привнести в розмірене життя аристократа дух пригод."),
        FilmModel("Безславні виродки", 2009, R.drawable.inglor, "Друга світова війна." +
                " Перший рік окупації Франції німецькими військами. Союзний офіцер лейтенант Альдо Рейн збирає команду" +
                " із солдатів єврейського походження для здійснення насильницьких актів відплати над нацистами," +
                " у тому числі зняття з них скальпів. Волею долі Альдо зустрічає своїм шляхом власницю театру Шошенну Дрейфус," +
                " яка також прагне помститися нацистам за страту своєї сім'ї."),
        FilmModel("12 років рабства", 2013, R.drawable.slave, "Соломон Нортап був одруженим" +
                " і освіченим чоловіком, який жив і працював у Нью-Йорку, коли двоє людей одного разу запропонували" +
                " йому привабливу роботу у Вашингтоні. Після прибуття він був викрадений, став рабом і тягнув жалюгідне життя," +
                " переходячи від одного господаря до іншого.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter.addFilm(filmsList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentListBinding.bind(view)
        binding.apply{
        rvFilm.adapter=adapter
        }
    }

    private fun showMore(film: FilmModel)
    {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToAboutFragment(film))
    }
}