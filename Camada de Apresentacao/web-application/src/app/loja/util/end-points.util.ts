import { environment } from './../../../environments/environment.prod';


export const URL_AUTENTICACAO = `${environment.API_URL}/api/autenticacao`;
export const URL_CONTROLE_VENDAS = `${environment.API_URL}/api/controle-vendas`;
export const URL_CATEGORIAS = `${environment.API_URL}/api/controle-vendas/categorias`;
export const URL_PRODUTOS = `${environment.API_URL}/api/controle-vendas/produtos`;
export const URL_ENDERECOS = `${environment.API_URL}/api/controle-vendas/enderecos`;
export const URL_PEDIDOS = `${environment.API_URL}/api/controle-vendas/pedidos`;
export const BASIC_AUTHORIZATION = 'Basic ZHJvcHNoaXBwaW5nLWNsaWVudDpkcm9wc2hpcHBpbmctc2VjcmV0';
export const GRANT_TYPE_AUTHORIZATION = 'password';
