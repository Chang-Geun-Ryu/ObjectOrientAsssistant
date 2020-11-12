package academy.pocu.comp2500.assignment3;

public interface ICollisionEventable {
    void event();
    AttackIntent attack();
    void onAttacked(int damage);
    UnitKind getUnitKind();
}
