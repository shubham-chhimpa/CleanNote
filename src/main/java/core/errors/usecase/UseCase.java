package core.errors.usecase;

import core.errors.failures.Failure;
import io.vavr.control.Either;

public interface UseCase<Type, Params> {
    Either<Failure, Type> execute(Params params);
}
