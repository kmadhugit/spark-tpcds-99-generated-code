/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private int value1;
/* 009 */   private UnsafeRow result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 012 */
/* 013 */   public SpecificUnsafeProjection(Object[] references) {
/* 014 */     this.references = references;
/* 015 */
/* 016 */     result = new UnsafeRow(1);
/* 017 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 018 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 019 */
/* 020 */   }
/* 021 */
/* 022 */   public void initialize(int partitionIndex) {
/* 023 */
/* 024 */   }
/* 025 */
/* 026 */
/* 027 */   private void apply_1(InternalRow i) {
/* 028 */
/* 029 */     boolean isNull7 = i.isNullAt(5);
/* 030 */     long value7 = isNull7 ? -1L : (i.getLong(5));
/* 031 */     if (!isNull7) {
/* 032 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(value7, value1);
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull8 = i.isNullAt(6);
/* 036 */     double value8 = isNull8 ? -1.0 : (i.getDouble(6));
/* 037 */     if (!isNull8) {
/* 038 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(Double.doubleToLongBits(value8), value1);
/* 039 */     }
/* 040 */
/* 041 */   }
/* 042 */
/* 043 */
/* 044 */   private void apply_0(InternalRow i) {
/* 045 */
/* 046 */     boolean isNull2 = i.isNullAt(0);
/* 047 */     int value2 = isNull2 ? -1 : (i.getInt(0));
/* 048 */     if (!isNull2) {
/* 049 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value2, value1);
/* 050 */     }
/* 051 */
/* 052 */     boolean isNull3 = i.isNullAt(1);
/* 053 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 054 */     if (!isNull3) {
/* 055 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value3, value1);
/* 056 */     }
/* 057 */
/* 058 */     boolean isNull4 = i.isNullAt(2);
/* 059 */     int value4 = isNull4 ? -1 : (i.getInt(2));
/* 060 */     if (!isNull4) {
/* 061 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value4, value1);
/* 062 */     }
/* 063 */
/* 064 */     boolean isNull5 = i.isNullAt(3);
/* 065 */     int value5 = isNull5 ? -1 : (i.getInt(3));
/* 066 */     if (!isNull5) {
/* 067 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value5, value1);
/* 068 */     }
/* 069 */
/* 070 */     boolean isNull6 = i.isNullAt(4);
/* 071 */     int value6 = isNull6 ? -1 : (i.getInt(4));
/* 072 */     if (!isNull6) {
/* 073 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value6, value1);
/* 074 */     }
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */
/* 079 */   // Scala.Function1 need this
/* 080 */   public java.lang.Object apply(java.lang.Object row) {
/* 081 */     return apply((InternalRow) row);
/* 082 */   }
/* 083 */
/* 084 */   public UnsafeRow apply(InternalRow i) {
/* 085 */     boolean isNull = false;
/* 086 */
/* 087 */     value1 = 42;
/* 088 */     apply_0(i);
/* 089 */     apply_1(i);
/* 090 */
/* 091 */     int value = -1;
/* 092 */
/* 093 */     int remainder = value1 % 64;
/* 094 */     if (remainder < 0) {
/* 095 */       value = (remainder + 64) % 64;
/* 096 */     } else {
/* 097 */       value = remainder;
/* 098 */     }
/* 099 */     rowWriter.write(0, value);
/* 100 */     return result;
/* 101 */   }
/* 102 */ }
