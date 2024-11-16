
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import MenuMenuManager from "./components/listers/MenuMenuCards"
import MenuMenuDetail from "./components/listers/MenuMenuDetail"

import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"


import CouponCouponManager from "./components/listers/CouponCouponCards"
import CouponCouponDetail from "./components/listers/CouponCouponDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/menus/menus',
                name: 'MenuMenuManager',
                component: MenuMenuManager
            },
            {
                path: '/menus/menus/:id',
                name: 'MenuMenuDetail',
                component: MenuMenuDetail
            },

            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },


            {
                path: '/coupons/coupons',
                name: 'CouponCouponManager',
                component: CouponCouponManager
            },
            {
                path: '/coupons/coupons/:id',
                name: 'CouponCouponDetail',
                component: CouponCouponDetail
            },



    ]
})
