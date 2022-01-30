package ch.sascha.tbz.views;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The main view is a top-level placeholder for other views.
 */
@PWA(name = "LB2-Hospitalify", shortName = "LB2-Hospitalify", enableInstallPrompt = false)
@Theme(themeFolder = "lb2-hospitalify", variant = Lumo.DARK)
@PageTitle("Main")
public class MainLayout extends AppLayout {

    /**
     * A simple navigation item component, based on ListItem element.
     */
    public static class MenuItemInfo extends ListItem {

        /**
         * Contained views
         */
        private final Class<? extends Component> view;

        /**
         * Setup Menu items for switching between views
         * @param menuTitle     String menu title
         * @param iconClass     String icon class
         * @param view          View web page
         */
        public MenuItemInfo(String menuTitle, String iconClass, Class<? extends Component> view) {
            this.view = view;
            RouterLink link = new RouterLink();
            // Use Lumo classnames for various styling
            link.addClassNames("flex", "mx-s", "p-s", "relative", "text-secondary");
            link.setRoute(view);

            Span text = new Span(menuTitle);
            // Use Lumo classnames for various styling
            text.addClassNames("font-medium", "text-s");

            link.add(new LineAwesomeIcon(iconClass), text);
            add(link);
        }

        public Class<?> getView() {
            return view;
        }

        /**
         * Simple wrapper to create icons using LineAwesome iconset. See
         * https://icons8.com/line-awesome
         */
        @NpmPackage(value = "line-awesome", version = "1.3.0")
        public static class LineAwesomeIcon extends Span {
            /**
             * Constructor for fetching classnames
             * @param lineawesomeClassnames     String for font
             */
            public LineAwesomeIcon(String lineawesomeClassnames) {
                // Use Lumo classnames for suitable font size and margin
                addClassNames("me-s", "text-l");
                if (!lineawesomeClassnames.isEmpty()) {
                    addClassNames(lineawesomeClassnames);
                }
            }
        }

    }

    private H1 viewTitle;

    /**
     * Constructor for creating main layout
     */
    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        addToDrawer(createDrawerContent());
    }

    /**
     * Creates Header Content and toggle hamburger icon
     * @return          Custom Component
     */
    private Component createHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.addClassName("text-secondary");
        toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames("m-0", "text-l");

        Header header = new Header(toggle, viewTitle);
        header.addClassNames("bg-base", "border-b", "border-contrast-10", "box-border", "flex", "h-xl", "items-center",
                "w-full");
        return header;
    }

    /**
     *  Creates Drawer content in the main layout
     * @return          Custom component for HTML elements
     */
    private Component createDrawerContent() {
        H2 appName = new H2("LB2-Hospitalify");
        appName.addClassNames("flex", "items-center", "h-xl", "m-0", "px-m", "text-m");

        com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
                createNavigation(), createFooter());
        section.addClassNames("flex", "flex-col", "items-stretch", "max-h-full", "min-h-full");
        return section;
    }

    /**
     * Creates navigation list in main layout
     * @return          Nav object which represents a
     */
    private Nav createNavigation() {
        Nav nav = new Nav();
        nav.addClassNames("border-b", "border-contrast-10", "flex-grow", "overflow-auto");
        nav.getElement().setAttribute("aria-labelledby", "views");

        // Wrap the links in a list; improves accessibility
        UnorderedList list = new UnorderedList();
        list.addClassNames("list-none", "m-0", "p-0");
        nav.add(list);

        for (MenuItemInfo menuItem : createMenuItems()) {
            list.add(menuItem);

        }
        return nav;
    }

    /**
     * Creates menu items to pick.
     * @return          Array of MenuItemInfo objects for every view
     */
    private MenuItemInfo[] createMenuItems() {
        return new MenuItemInfo[]{ //
                new MenuItemInfo("Patient Form", "la la-user", PatientFormView.class),

                new MenuItemInfo("Staff Form", "la la-user", StaffFormView.class),

                new MenuItemInfo("Admin Detail", "la la-cog", AdminDetailView.class),

                new MenuItemInfo("Address Form", "la la-map-marker", AddressFormView.class),

        };
    }

    /**
     * Creates a simple a footer component
     * @return      Footer component
     */
    private Footer createFooter() {
        Footer layout = new Footer();
        layout.addClassNames("flex", "items-center", "my-s", "px-m", "py-xs");
        return layout;
    }

    /**
     * Update current page in drawer element
     */
    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    /**
     * Fetches current page Title
     * @return          String of current page title
     */
    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
