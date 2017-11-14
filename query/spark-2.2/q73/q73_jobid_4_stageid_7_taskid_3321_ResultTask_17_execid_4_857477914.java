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
/* 012 */   private int smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private int smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private long smj_value6;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 021 */   private UnsafeRow smj_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     smj_leftInput = inputs[0];
/* 036 */     smj_rightInput = inputs[1];
/* 037 */
/* 038 */     smj_rightRow = null;
/* 039 */
/* 040 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 041 */
/* 042 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     smj_result = new UnsafeRow(8);
/* 044 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 128);
/* 045 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 8);
/* 046 */     project_result = new UnsafeRow(6);
/* 047 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 048 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 049 */
/* 050 */   }
/* 051 */
/* 052 */   private boolean findNextInnerJoinRows(
/* 053 */     scala.collection.Iterator leftIter,
/* 054 */     scala.collection.Iterator rightIter) {
/* 055 */     smj_leftRow = null;
/* 056 */     int comp = 0;
/* 057 */     while (smj_leftRow == null) {
/* 058 */       if (!leftIter.hasNext()) return false;
/* 059 */       smj_leftRow = (InternalRow) leftIter.next();
/* 060 */
/* 061 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 062 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 063 */       if (smj_isNull) {
/* 064 */         smj_leftRow = null;
/* 065 */         continue;
/* 066 */       }
/* 067 */       if (!smj_matches.isEmpty()) {
/* 068 */         comp = 0;
/* 069 */         if (comp == 0) {
/* 070 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 071 */         }
/* 072 */
/* 073 */         if (comp == 0) {
/* 074 */           return true;
/* 075 */         }
/* 076 */         smj_matches.clear();
/* 077 */       }
/* 078 */
/* 079 */       do {
/* 080 */         if (smj_rightRow == null) {
/* 081 */           if (!rightIter.hasNext()) {
/* 082 */             smj_value3 = smj_value;
/* 083 */             return !smj_matches.isEmpty();
/* 084 */           }
/* 085 */           smj_rightRow = (InternalRow) rightIter.next();
/* 086 */
/* 087 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 088 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 089 */           if (smj_isNull1) {
/* 090 */             smj_rightRow = null;
/* 091 */             continue;
/* 092 */           }
/* 093 */           smj_value2 = smj_value1;
/* 094 */         }
/* 095 */
/* 096 */         comp = 0;
/* 097 */         if (comp == 0) {
/* 098 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 099 */         }
/* 100 */
/* 101 */         if (comp > 0) {
/* 102 */           smj_rightRow = null;
/* 103 */         } else if (comp < 0) {
/* 104 */           if (!smj_matches.isEmpty()) {
/* 105 */             smj_value3 = smj_value;
/* 106 */             return true;
/* 107 */           }
/* 108 */           smj_leftRow = null;
/* 109 */         } else {
/* 110 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 111 */           smj_rightRow = null;;
/* 112 */         }
/* 113 */       } while (smj_leftRow != null);
/* 114 */     }
/* 115 */     return false; // unreachable
/* 116 */   }
/* 117 */
/* 118 */   protected void processNext() throws java.io.IOException {
/* 119 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 120 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 121 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 122 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 123 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 124 */       smj_value6 = smj_leftRow.getLong(2);
/* 125 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 126 */       while (smj_iterator.hasNext()) {
/* 127 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 128 */
/* 129 */         smj_numOutputRows.add(1);
/* 130 */
/* 131 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(3);
/* 132 */         UTF8String smj_value10 = smj_isNull7 ? null : (smj_rightRow1.getUTF8String(3));
/* 133 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(2);
/* 134 */         UTF8String smj_value9 = smj_isNull6 ? null : (smj_rightRow1.getUTF8String(2));
/* 135 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 136 */         UTF8String smj_value8 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(1));
/* 137 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(4);
/* 138 */         UTF8String smj_value11 = smj_isNull8 ? null : (smj_rightRow1.getUTF8String(4));
/* 139 */         project_holder.reset();
/* 140 */
/* 141 */         project_rowWriter.zeroOutNullBytes();
/* 142 */
/* 143 */         if (smj_isNull7) {
/* 144 */           project_rowWriter.setNullAt(0);
/* 145 */         } else {
/* 146 */           project_rowWriter.write(0, smj_value10);
/* 147 */         }
/* 148 */
/* 149 */         if (smj_isNull6) {
/* 150 */           project_rowWriter.setNullAt(1);
/* 151 */         } else {
/* 152 */           project_rowWriter.write(1, smj_value9);
/* 153 */         }
/* 154 */
/* 155 */         if (smj_isNull5) {
/* 156 */           project_rowWriter.setNullAt(2);
/* 157 */         } else {
/* 158 */           project_rowWriter.write(2, smj_value8);
/* 159 */         }
/* 160 */
/* 161 */         if (smj_isNull8) {
/* 162 */           project_rowWriter.setNullAt(3);
/* 163 */         } else {
/* 164 */           project_rowWriter.write(3, smj_value11);
/* 165 */         }
/* 166 */
/* 167 */         if (smj_isNull2) {
/* 168 */           project_rowWriter.setNullAt(4);
/* 169 */         } else {
/* 170 */           project_rowWriter.write(4, smj_value4);
/* 171 */         }
/* 172 */
/* 173 */         project_rowWriter.write(5, smj_value6);
/* 174 */         project_result.setTotalSize(project_holder.totalSize());
/* 175 */         append(project_result.copy());
/* 176 */
/* 177 */       }
/* 178 */       if (shouldStop()) return;
/* 179 */     }
/* 180 */   }
/* 181 */ }
