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
/* 029 */     boolean isNull6 = true;
/* 030 */     int value6 = -1;
/* 031 */
/* 032 */     boolean isNull7 = i.isNullAt(5);
/* 033 */     int value7 = isNull7 ? -1 : (i.getInt(5));
/* 034 */     if (!isNull7) {
/* 035 */
/* 036 */
/* 037 */       isNull6 = false; // resultCode could change nullability.
/* 038 */       value6 = value7 + 1;
/* 039 */
/* 040 */     }
/* 041 */     if (!isNull6) {
/* 042 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value6, value1);
/* 043 */     }
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */
/* 048 */   private void apply_0(InternalRow i) {
/* 049 */
/* 050 */     boolean isNull2 = i.isNullAt(0);
/* 051 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 052 */     if (!isNull2) {
/* 053 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 054 */     }
/* 055 */
/* 056 */     boolean isNull3 = i.isNullAt(1);
/* 057 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 058 */     if (!isNull3) {
/* 059 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value3.getBaseObject(), value3.getBaseOffset(), value3.numBytes(), value1);
/* 060 */     }
/* 061 */
/* 062 */     boolean isNull4 = i.isNullAt(2);
/* 063 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 064 */     if (!isNull4) {
/* 065 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 066 */     }
/* 067 */
/* 068 */     boolean isNull5 = i.isNullAt(3);
/* 069 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 070 */     if (!isNull5) {
/* 071 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value5.getBaseObject(), value5.getBaseOffset(), value5.numBytes(), value1);
/* 072 */     }
/* 073 */
/* 074 */   }
/* 075 */
/* 076 */
/* 077 */   // Scala.Function1 need this
/* 078 */   public java.lang.Object apply(java.lang.Object row) {
/* 079 */     return apply((InternalRow) row);
/* 080 */   }
/* 081 */
/* 082 */   public UnsafeRow apply(InternalRow i) {
/* 083 */     boolean isNull = false;
/* 084 */
/* 085 */     value1 = 42;
/* 086 */     apply_0(i);
/* 087 */     apply_1(i);
/* 088 */
/* 089 */     int value = -1;
/* 090 */
/* 091 */     int remainder = value1 % 64;
/* 092 */     if (remainder < 0) {
/* 093 */       value = (remainder + 64) % 64;
/* 094 */     } else {
/* 095 */       value = remainder;
/* 096 */     }
/* 097 */     rowWriter.write(0, value);
/* 098 */     return result;
/* 099 */   }
/* 100 */ }
