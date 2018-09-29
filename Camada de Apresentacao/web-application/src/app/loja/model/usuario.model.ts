interface UsuarioModel {
    idUsuario: number;
    nome: string;
    email: string;
    token: string;
    perfil: PerfilModel[];
}
