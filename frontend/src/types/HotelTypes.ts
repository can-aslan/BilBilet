export type Hotel = {
	name: string;
	avgPrice: number;
	telephone: string;
	websiteUrl: string;
	coverPhotoUrl: string;
	photoUrl: string;
	rating: number;
	hotelId: number;
	addressId: number;
};

export type AddHotel = {
	hotel: Hotel;
	city: string;
	country: string;
};

export type HotelFilterParams = {
	addressId: number;
};
