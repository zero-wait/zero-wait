import { api } from "./config/axiosConfig.ts";

export interface Restaurant {
    restaurantId: number;
    name: string;
    address: string;
    tel: string;
    imageUrl: string;
    ratingAvg: number;
    categoryId: number;
    isOpen: number;
    waitingCount: number;
    estimatedWaitingTime: number;
}

export const getList = (categoryId?: number, isOpen?: boolean) => {
    return api.get<Restaurant[]>(`/api/restaurants/get`, {
        params: { categoryId, isOpen }
    });
};