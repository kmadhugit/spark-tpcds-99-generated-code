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
/* 017 */   private double smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private UTF8String smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private UTF8String smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private UTF8String smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private double smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 028 */   private UnsafeRow smj_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */
/* 035 */   public GeneratedIterator(Object[] references) {
/* 036 */     this.references = references;
/* 037 */   }
/* 038 */
/* 039 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 040 */     partitionIndex = index;
/* 041 */     this.inputs = inputs;
/* 042 */     smj_leftInput = inputs[0];
/* 043 */     smj_rightInput = inputs[1];
/* 044 */
/* 045 */     smj_rightRow = null;
/* 046 */
/* 047 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 048 */
/* 049 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 050 */     smj_result = new UnsafeRow(8);
/* 051 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 160);
/* 052 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 8);
/* 053 */     project_result = new UnsafeRow(7);
/* 054 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 055 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private boolean findNextInnerJoinRows(
/* 060 */     scala.collection.Iterator leftIter,
/* 061 */     scala.collection.Iterator rightIter) {
/* 062 */     smj_leftRow = null;
/* 063 */     int comp = 0;
/* 064 */     while (smj_leftRow == null) {
/* 065 */       if (!leftIter.hasNext()) return false;
/* 066 */       smj_leftRow = (InternalRow) leftIter.next();
/* 067 */
/* 068 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 069 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 070 */       if (smj_isNull) {
/* 071 */         smj_leftRow = null;
/* 072 */         continue;
/* 073 */       }
/* 074 */       if (!smj_matches.isEmpty()) {
/* 075 */         comp = 0;
/* 076 */         if (comp == 0) {
/* 077 */           comp = smj_value.compare(smj_value3);
/* 078 */         }
/* 079 */
/* 080 */         if (comp == 0) {
/* 081 */           return true;
/* 082 */         }
/* 083 */         smj_matches.clear();
/* 084 */       }
/* 085 */
/* 086 */       do {
/* 087 */         if (smj_rightRow == null) {
/* 088 */           if (!rightIter.hasNext()) {
/* 089 */             smj_value3 = smj_value.clone();
/* 090 */             return !smj_matches.isEmpty();
/* 091 */           }
/* 092 */           smj_rightRow = (InternalRow) rightIter.next();
/* 093 */
/* 094 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 095 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 096 */           if (smj_isNull1) {
/* 097 */             smj_rightRow = null;
/* 098 */             continue;
/* 099 */           }
/* 100 */           smj_value2 = smj_value1.clone();
/* 101 */         }
/* 102 */
/* 103 */         comp = 0;
/* 104 */         if (comp == 0) {
/* 105 */           comp = smj_value.compare(smj_value2);
/* 106 */         }
/* 107 */
/* 108 */         if (comp > 0) {
/* 109 */           smj_rightRow = null;
/* 110 */         } else if (comp < 0) {
/* 111 */           if (!smj_matches.isEmpty()) {
/* 112 */             smj_value3 = smj_value.clone();
/* 113 */             return true;
/* 114 */           }
/* 115 */           smj_leftRow = null;
/* 116 */         } else {
/* 117 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 118 */           smj_rightRow = null;;
/* 119 */         }
/* 120 */       } while (smj_leftRow != null);
/* 121 */     }
/* 122 */     return false; // unreachable
/* 123 */   }
/* 124 */
/* 125 */   protected void processNext() throws java.io.IOException {
/* 126 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 127 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 128 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 129 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 130 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 131 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 132 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 133 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 134 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 135 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 136 */       smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 137 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 138 */       smj_value9 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(5));
/* 139 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 140 */       while (smj_iterator.hasNext()) {
/* 141 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 142 */
/* 143 */         smj_numOutputRows.add(1);
/* 144 */
/* 145 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(1);
/* 146 */         double smj_value11 = smj_isNull9 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 147 */         project_holder.reset();
/* 148 */
/* 149 */         project_rowWriter.zeroOutNullBytes();
/* 150 */
/* 151 */         if (smj_isNull2) {
/* 152 */           project_rowWriter.setNullAt(0);
/* 153 */         } else {
/* 154 */           project_rowWriter.write(0, smj_value4);
/* 155 */         }
/* 156 */
/* 157 */         if (smj_isNull3) {
/* 158 */           project_rowWriter.setNullAt(1);
/* 159 */         } else {
/* 160 */           project_rowWriter.write(1, smj_value5);
/* 161 */         }
/* 162 */
/* 163 */         if (smj_isNull4) {
/* 164 */           project_rowWriter.setNullAt(2);
/* 165 */         } else {
/* 166 */           project_rowWriter.write(2, smj_value6);
/* 167 */         }
/* 168 */
/* 169 */         if (smj_isNull5) {
/* 170 */           project_rowWriter.setNullAt(3);
/* 171 */         } else {
/* 172 */           project_rowWriter.write(3, smj_value7);
/* 173 */         }
/* 174 */
/* 175 */         if (smj_isNull6) {
/* 176 */           project_rowWriter.setNullAt(4);
/* 177 */         } else {
/* 178 */           project_rowWriter.write(4, smj_value8);
/* 179 */         }
/* 180 */
/* 181 */         if (smj_isNull7) {
/* 182 */           project_rowWriter.setNullAt(5);
/* 183 */         } else {
/* 184 */           project_rowWriter.write(5, smj_value9);
/* 185 */         }
/* 186 */
/* 187 */         if (smj_isNull9) {
/* 188 */           project_rowWriter.setNullAt(6);
/* 189 */         } else {
/* 190 */           project_rowWriter.write(6, smj_value11);
/* 191 */         }
/* 192 */         project_result.setTotalSize(project_holder.totalSize());
/* 193 */         append(project_result.copy());
/* 194 */
/* 195 */       }
/* 196 */       if (shouldStop()) return;
/* 197 */     }
/* 198 */   }
/* 199 */ }
