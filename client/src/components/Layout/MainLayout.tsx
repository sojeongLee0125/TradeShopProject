import Header from '../header/Header';
import CartingModal from '../CartingModal/CartingModal';
import { Outlet } from 'react-router-dom';
const MainLayout = () => {
  return (
    <>
      <Header />
      <CartingModal />
      <Outlet />
    </>
  );
};
/**App컴포넌트에서  MainLayout 안에 감싸진 컴포넌트들은 Outlet으로 표시된다*/
export default MainLayout;
