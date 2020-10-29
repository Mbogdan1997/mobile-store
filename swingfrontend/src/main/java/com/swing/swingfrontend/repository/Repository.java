package com.swing.swingfrontend.repository;

import com.swing.swingfrontend.accesory.AccesoryController;
import com.swing.swingfrontend.admin.Admin;
import com.swing.swingfrontend.admin.AdminController;
import com.swing.swingfrontend.admin.OrderViewController;
import com.swing.swingfrontend.gateway.*;
import com.swing.swingfrontend.login.LoginController;
import com.swing.swingfrontend.mobile.MobileController;
import com.swing.swingfrontend.noadmin.*;
import com.swing.swingfrontend.rest.RestProperties;
import com.swing.swingfrontend.service.DataConverter;
import com.swing.swingfrontend.service.DataConverterImpl;
import com.swing.swingfrontend.session.CurrentSession;
import com.swing.swingfrontend.user.UserViewController;

public class Repository {

    public static final RestProperties REST_PROPERTIES=new RestProperties();
    private  final ItemGateway itemGateway=new ItemGatewayImpl();
    private final DataConverter dataConverter=new DataConverterImpl();
    private final CurrentSession currentSession=new CurrentSession();
    private final UserGateway userGateway=new UserGatewayImpl();
    private final MobileGateway mobileGateway=new MobileGatewayImpl();
    private final AccesoryGateway accesoryGateway=new AccesoryGatewayImpl();
    private  final ShoppingBascketItemGateway shoppingBascketItemGateway=new ShoppingBascketItemGatewayImpl();

    private final ShoppingBascketGateway shoppingBascketGateway=new ShoppingBascketGatewayImpl();
    private final UserViewController userViewController=new UserViewController(userGateway,dataConverter);
    private final MobileController mobileController=new MobileController(dataConverter,mobileGateway,itemGateway);
    private  final AccesoryController accesoryController=new AccesoryController(itemGateway,dataConverter,accesoryGateway);
    private final OrderGateway orderGateway=new OrderGatewayImpl();
    private final OrderViewController orderViewController=new OrderViewController(orderGateway,dataConverter);
    private final AdminController adminController=new AdminController(orderViewController,userViewController,mobileController,accesoryController);
    private final MobileShopController mobileShopController=new MobileShopController(currentSession,shoppingBascketItemGateway,mobileGateway,dataConverter);
    private final AccesoryShopController accesoryShopController=new AccesoryShopController(shoppingBascketItemGateway,accesoryGateway,dataConverter,currentSession);

    private final AdressGateway adressGateway=new AdressGatewayImpl();

    private final OrderController orderController=new OrderController(shoppingBascketGateway,orderGateway,adressGateway,currentSession);

    private final ShoppingBascketController shoppingBascketController=new ShoppingBascketController(orderController,shoppingBascketGateway,dataConverter,currentSession,shoppingBascketItemGateway);

    private final UserController userController=new UserController(shoppingBascketController,mobileShopController,accesoryShopController);
    private final LoginController loginController=new LoginController(shoppingBascketGateway,userController,currentSession,userGateway,adminController);


}