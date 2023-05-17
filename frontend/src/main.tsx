import React from "react";
import ReactDOM from "react-dom/client";
import { QueryClient, QueryClientProvider } from "react-query";
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import ProviderWrapper from "./components/common/ProviderWrapper";
import "./index.css";
import Layout from "./layout";
import LoginPage from "./pages/login/LoginPage";
import RegisterPage from "./pages/login/RegisterPage";
import SearchRentCarPage from "./pages/rent-car/SearchRentCarPage";
import AddCarPage from "./pages/rent-car/AddCarPage";

const router = createBrowserRouter([
  {
    children: [
      {
        path: "/",
        element: <Layout />,
        children: [
          {
            path: "/login",
            element: <LoginPage />,
          },
          {
            path: "/register",
            element: <RegisterPage />,
          },
          {
            path: "/car-rent-searchbar",
            element: <SearchRentCarPage />,
          },
          {
            path: "/add-car",
            element: <AddCarPage />,
          },
        ],
      },
    ],
  },
]);
const queryClient = new QueryClient();

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <ProviderWrapper>
        <RouterProvider router={router} />
      </ProviderWrapper>
    </QueryClientProvider>
  </React.StrictMode>
);
