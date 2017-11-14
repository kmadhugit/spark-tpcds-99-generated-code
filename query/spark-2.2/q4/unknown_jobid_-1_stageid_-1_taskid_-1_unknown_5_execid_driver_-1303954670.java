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
/* 025 */   private UTF8String smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private UTF8String smj_value10;
/* 028 */   private boolean smj_isNull8;
/* 029 */   private UTF8String smj_value11;
/* 030 */   private boolean smj_isNull9;
/* 031 */   private UTF8String smj_value12;
/* 032 */   private boolean smj_isNull10;
/* 033 */   private double smj_value13;
/* 034 */   private boolean smj_isNull11;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 036 */   private UnsafeRow smj_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 039 */   private UnsafeRow project_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 042 */
/* 043 */   public GeneratedIterator(Object[] references) {
/* 044 */     this.references = references;
/* 045 */   }
/* 046 */
/* 047 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 048 */     partitionIndex = index;
/* 049 */     this.inputs = inputs;
/* 050 */     smj_leftInput = inputs[0];
/* 051 */     smj_rightInput = inputs[1];
/* 052 */
/* 053 */     smj_rightRow = null;
/* 054 */
/* 055 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 056 */
/* 057 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 058 */     smj_result = new UnsafeRow(12);
/* 059 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 288);
/* 060 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 061 */     project_result = new UnsafeRow(11);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 256);
/* 063 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private boolean findNextInnerJoinRows(
/* 068 */     scala.collection.Iterator leftIter,
/* 069 */     scala.collection.Iterator rightIter) {
/* 070 */     smj_leftRow = null;
/* 071 */     int comp = 0;
/* 072 */     while (smj_leftRow == null) {
/* 073 */       if (!leftIter.hasNext()) return false;
/* 074 */       smj_leftRow = (InternalRow) leftIter.next();
/* 075 */
/* 076 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 077 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 078 */       if (smj_isNull) {
/* 079 */         smj_leftRow = null;
/* 080 */         continue;
/* 081 */       }
/* 082 */       if (!smj_matches.isEmpty()) {
/* 083 */         comp = 0;
/* 084 */         if (comp == 0) {
/* 085 */           comp = smj_value.compare(smj_value3);
/* 086 */         }
/* 087 */
/* 088 */         if (comp == 0) {
/* 089 */           return true;
/* 090 */         }
/* 091 */         smj_matches.clear();
/* 092 */       }
/* 093 */
/* 094 */       do {
/* 095 */         if (smj_rightRow == null) {
/* 096 */           if (!rightIter.hasNext()) {
/* 097 */             smj_value3 = smj_value.clone();
/* 098 */             return !smj_matches.isEmpty();
/* 099 */           }
/* 100 */           smj_rightRow = (InternalRow) rightIter.next();
/* 101 */
/* 102 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 103 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 104 */           if (smj_isNull1) {
/* 105 */             smj_rightRow = null;
/* 106 */             continue;
/* 107 */           }
/* 108 */           smj_value2 = smj_value1.clone();
/* 109 */         }
/* 110 */
/* 111 */         comp = 0;
/* 112 */         if (comp == 0) {
/* 113 */           comp = smj_value.compare(smj_value2);
/* 114 */         }
/* 115 */
/* 116 */         if (comp > 0) {
/* 117 */           smj_rightRow = null;
/* 118 */         } else if (comp < 0) {
/* 119 */           if (!smj_matches.isEmpty()) {
/* 120 */             smj_value3 = smj_value.clone();
/* 121 */             return true;
/* 122 */           }
/* 123 */           smj_leftRow = null;
/* 124 */         } else {
/* 125 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 126 */           smj_rightRow = null;;
/* 127 */         }
/* 128 */       } while (smj_leftRow != null);
/* 129 */     }
/* 130 */     return false; // unreachable
/* 131 */   }
/* 132 */
/* 133 */   protected void processNext() throws java.io.IOException {
/* 134 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 135 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 136 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 137 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 138 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 139 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 140 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 141 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 142 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 143 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 144 */       smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 145 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 146 */       smj_value9 = smj_isNull7 ? null : (smj_leftRow.getUTF8String(5));
/* 147 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 148 */       smj_value10 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(6));
/* 149 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 150 */       smj_value11 = smj_isNull9 ? null : (smj_leftRow.getUTF8String(7));
/* 151 */       smj_isNull10 = smj_leftRow.isNullAt(8);
/* 152 */       smj_value12 = smj_isNull10 ? null : (smj_leftRow.getUTF8String(8));
/* 153 */       smj_isNull11 = smj_leftRow.isNullAt(9);
/* 154 */       smj_value13 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(9));
/* 155 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 156 */       while (smj_iterator.hasNext()) {
/* 157 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 158 */
/* 159 */         smj_numOutputRows.add(1);
/* 160 */
/* 161 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(1);
/* 162 */         double smj_value15 = smj_isNull13 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 163 */         project_holder.reset();
/* 164 */
/* 165 */         project_rowWriter.zeroOutNullBytes();
/* 166 */
/* 167 */         if (smj_isNull2) {
/* 168 */           project_rowWriter.setNullAt(0);
/* 169 */         } else {
/* 170 */           project_rowWriter.write(0, smj_value4);
/* 171 */         }
/* 172 */
/* 173 */         if (smj_isNull3) {
/* 174 */           project_rowWriter.setNullAt(1);
/* 175 */         } else {
/* 176 */           project_rowWriter.write(1, smj_value5);
/* 177 */         }
/* 178 */
/* 179 */         if (smj_isNull4) {
/* 180 */           project_rowWriter.setNullAt(2);
/* 181 */         } else {
/* 182 */           project_rowWriter.write(2, smj_value6);
/* 183 */         }
/* 184 */
/* 185 */         if (smj_isNull5) {
/* 186 */           project_rowWriter.setNullAt(3);
/* 187 */         } else {
/* 188 */           project_rowWriter.write(3, smj_value7);
/* 189 */         }
/* 190 */
/* 191 */         if (smj_isNull6) {
/* 192 */           project_rowWriter.setNullAt(4);
/* 193 */         } else {
/* 194 */           project_rowWriter.write(4, smj_value8);
/* 195 */         }
/* 196 */
/* 197 */         if (smj_isNull7) {
/* 198 */           project_rowWriter.setNullAt(5);
/* 199 */         } else {
/* 200 */           project_rowWriter.write(5, smj_value9);
/* 201 */         }
/* 202 */
/* 203 */         if (smj_isNull8) {
/* 204 */           project_rowWriter.setNullAt(6);
/* 205 */         } else {
/* 206 */           project_rowWriter.write(6, smj_value10);
/* 207 */         }
/* 208 */
/* 209 */         if (smj_isNull9) {
/* 210 */           project_rowWriter.setNullAt(7);
/* 211 */         } else {
/* 212 */           project_rowWriter.write(7, smj_value11);
/* 213 */         }
/* 214 */
/* 215 */         if (smj_isNull10) {
/* 216 */           project_rowWriter.setNullAt(8);
/* 217 */         } else {
/* 218 */           project_rowWriter.write(8, smj_value12);
/* 219 */         }
/* 220 */
/* 221 */         if (smj_isNull11) {
/* 222 */           project_rowWriter.setNullAt(9);
/* 223 */         } else {
/* 224 */           project_rowWriter.write(9, smj_value13);
/* 225 */         }
/* 226 */
/* 227 */         if (smj_isNull13) {
/* 228 */           project_rowWriter.setNullAt(10);
/* 229 */         } else {
/* 230 */           project_rowWriter.write(10, smj_value15);
/* 231 */         }
/* 232 */         project_result.setTotalSize(project_holder.totalSize());
/* 233 */         append(project_result.copy());
/* 234 */
/* 235 */       }
/* 236 */       if (shouldStop()) return;
/* 237 */     }
/* 238 */   }
/* 239 */ }
