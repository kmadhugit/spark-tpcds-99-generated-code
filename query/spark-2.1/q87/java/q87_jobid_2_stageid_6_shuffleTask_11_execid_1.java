/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(3);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 96);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 3);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     boolean isNull7 = i.isNullAt(2);
/* 029 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(2));
/* 030 */     boolean isNull6 = isNull7;
/* 031 */     UTF8String value6 = value7;
/* 032 */     if (isNull6) {
/* 033 */
/* 034 */       Object obj2 = ((Expression) references[2]).eval(null);
/* 035 */       UTF8String value8 = (UTF8String) obj2;
/* 036 */       if (!false) {
/* 037 */         isNull6 = false;
/* 038 */         value6 = value8;
/* 039 */       }
/* 040 */     }
/* 041 */     if (isNull6) {
/* 042 */       rowWriter.setNullAt(2);
/* 043 */     } else {
/* 044 */       rowWriter.write(2, value6);
/* 045 */     }
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */
/* 050 */   private void apply_0(InternalRow i) {
/* 051 */
/* 052 */
/* 053 */     boolean isNull1 = i.isNullAt(0);
/* 054 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 055 */     boolean isNull = isNull1;
/* 056 */     UTF8String value = value1;
/* 057 */     if (isNull) {
/* 058 */
/* 059 */       Object obj = ((Expression) references[0]).eval(null);
/* 060 */       UTF8String value2 = (UTF8String) obj;
/* 061 */       if (!false) {
/* 062 */         isNull = false;
/* 063 */         value = value2;
/* 064 */       }
/* 065 */     }
/* 066 */     if (isNull) {
/* 067 */       rowWriter.setNullAt(0);
/* 068 */     } else {
/* 069 */       rowWriter.write(0, value);
/* 070 */     }
/* 071 */
/* 072 */
/* 073 */     boolean isNull4 = i.isNullAt(1);
/* 074 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 075 */     boolean isNull3 = isNull4;
/* 076 */     UTF8String value3 = value4;
/* 077 */     if (isNull3) {
/* 078 */
/* 079 */       Object obj1 = ((Expression) references[1]).eval(null);
/* 080 */       UTF8String value5 = (UTF8String) obj1;
/* 081 */       if (!false) {
/* 082 */         isNull3 = false;
/* 083 */         value3 = value5;
/* 084 */       }
/* 085 */     }
/* 086 */     if (isNull3) {
/* 087 */       rowWriter.setNullAt(1);
/* 088 */     } else {
/* 089 */       rowWriter.write(1, value3);
/* 090 */     }
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */
/* 095 */   // Scala.Function1 need this
/* 096 */   public java.lang.Object apply(java.lang.Object row) {
/* 097 */     return apply((InternalRow) row);
/* 098 */   }
/* 099 */
/* 100 */   public UnsafeRow apply(InternalRow i) {
/* 101 */     holder.reset();
/* 102 */
/* 103 */     rowWriter.zeroOutNullBytes();
/* 104 */     apply_0(i);
/* 105 */     apply_1(i);
/* 106 */     result.setTotalSize(holder.totalSize());
/* 107 */     return result;
/* 108 */   }
/* 109 */ }
