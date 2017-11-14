/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private double smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 022 */   private UnsafeRow smj_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     smj_leftInput = inputs[0];
/* 034 */     smj_rightInput = inputs[1];
/* 035 */
/* 036 */     smj_rightRow = null;
/* 037 */
/* 038 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 039 */
/* 040 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 041 */     smj_result = new UnsafeRow(5);
/* 042 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 043 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */   private boolean findNextInnerJoinRows(
/* 048 */     scala.collection.Iterator leftIter,
/* 049 */     scala.collection.Iterator rightIter) {
/* 050 */     smj_leftRow = null;
/* 051 */     int comp = 0;
/* 052 */     while (smj_leftRow == null) {
/* 053 */       if (!leftIter.hasNext()) return false;
/* 054 */       smj_leftRow = (InternalRow) leftIter.next();
/* 055 */
/* 056 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 057 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 058 */       if (smj_isNull) {
/* 059 */         smj_leftRow = null;
/* 060 */         continue;
/* 061 */       }
/* 062 */       if (!smj_matches.isEmpty()) {
/* 063 */         comp = 0;
/* 064 */         if (comp == 0) {
/* 065 */           comp = smj_value.compare(smj_value3);
/* 066 */         }
/* 067 */
/* 068 */         if (comp == 0) {
/* 069 */           return true;
/* 070 */         }
/* 071 */         smj_matches.clear();
/* 072 */       }
/* 073 */
/* 074 */       do {
/* 075 */         if (smj_rightRow == null) {
/* 076 */           if (!rightIter.hasNext()) {
/* 077 */             smj_value3 = smj_value.clone();
/* 078 */             return !smj_matches.isEmpty();
/* 079 */           }
/* 080 */           smj_rightRow = (InternalRow) rightIter.next();
/* 081 */
/* 082 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 083 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 084 */           if (smj_isNull1) {
/* 085 */             smj_rightRow = null;
/* 086 */             continue;
/* 087 */           }
/* 088 */           smj_value2 = smj_value1.clone();
/* 089 */         }
/* 090 */
/* 091 */         comp = 0;
/* 092 */         if (comp == 0) {
/* 093 */           comp = smj_value.compare(smj_value2);
/* 094 */         }
/* 095 */
/* 096 */         if (comp > 0) {
/* 097 */           smj_rightRow = null;
/* 098 */         } else if (comp < 0) {
/* 099 */           if (!smj_matches.isEmpty()) {
/* 100 */             smj_value3 = smj_value.clone();
/* 101 */             return true;
/* 102 */           }
/* 103 */           smj_leftRow = null;
/* 104 */         } else {
/* 105 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 106 */           smj_rightRow = null;;
/* 107 */         }
/* 108 */       } while (smj_leftRow != null);
/* 109 */     }
/* 110 */     return false; // unreachable
/* 111 */   }
/* 112 */
/* 113 */   protected void processNext() throws java.io.IOException {
/* 114 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 115 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 116 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 117 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 118 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 119 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 120 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 121 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 122 */       while (smj_iterator.hasNext()) {
/* 123 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 124 */
/* 125 */         smj_numOutputRows.add(1);
/* 126 */
/* 127 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(0);
/* 128 */         UTF8String smj_value7 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(0));
/* 129 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(1);
/* 130 */         double smj_value8 = smj_isNull6 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 131 */         smj_holder.reset();
/* 132 */
/* 133 */         smj_rowWriter.zeroOutNullBytes();
/* 134 */
/* 135 */         if (smj_isNull2) {
/* 136 */           smj_rowWriter.setNullAt(0);
/* 137 */         } else {
/* 138 */           smj_rowWriter.write(0, smj_value4);
/* 139 */         }
/* 140 */
/* 141 */         if (smj_isNull3) {
/* 142 */           smj_rowWriter.setNullAt(1);
/* 143 */         } else {
/* 144 */           smj_rowWriter.write(1, smj_value5);
/* 145 */         }
/* 146 */
/* 147 */         if (smj_isNull4) {
/* 148 */           smj_rowWriter.setNullAt(2);
/* 149 */         } else {
/* 150 */           smj_rowWriter.write(2, smj_value6);
/* 151 */         }
/* 152 */
/* 153 */         if (smj_isNull5) {
/* 154 */           smj_rowWriter.setNullAt(3);
/* 155 */         } else {
/* 156 */           smj_rowWriter.write(3, smj_value7);
/* 157 */         }
/* 158 */
/* 159 */         if (smj_isNull6) {
/* 160 */           smj_rowWriter.setNullAt(4);
/* 161 */         } else {
/* 162 */           smj_rowWriter.write(4, smj_value8);
/* 163 */         }
/* 164 */         smj_result.setTotalSize(smj_holder.totalSize());
/* 165 */         append(smj_result.copy());
/* 166 */
/* 167 */       }
/* 168 */       if (shouldStop()) return;
/* 169 */     }
/* 170 */   }
/* 171 */ }
