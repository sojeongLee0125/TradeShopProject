import { configureStore, combineReducers } from '@reduxjs/toolkit';
import modalSlice from './modalSlice';
import loginSlice from './loginSlice';
import signupSlice from './signupSlice';
import logoReducer from './logoSlice';
import bannerReducer from './bannerSlice';
import googleLoginSlice from './oauthSlice';
import { persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';

const persistConfig = {
  key: 'root',
  storage,
  blacklist: ['login', 'signup'],
};
const reducer = combineReducers({
  modal: modalSlice,
  login: loginSlice,
  signup: signupSlice,
  logo: logoReducer,
  banner: bannerReducer,
  google: googleLoginSlice,
});
const persistedReducer = persistReducer(persistConfig, reducer);
export const store = configureStore({
  reducer: persistedReducer,
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: false,
    }),
});
export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
export default store;
