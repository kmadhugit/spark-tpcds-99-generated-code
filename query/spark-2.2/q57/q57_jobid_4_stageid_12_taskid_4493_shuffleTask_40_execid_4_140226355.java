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
/* 012 */   private UTF8String smj_value10;
/* 013 */   private UTF8String smj_value11;
/* 014 */   private UTF8String smj_value12;
/* 015 */   private int smj_value13;
/* 016 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 017 */   private UTF8String smj_value14;
/* 018 */   private UTF8String smj_value15;
/* 019 */   private UTF8String smj_value16;
/* 020 */   private int smj_value17;
/* 021 */   private UTF8String smj_value18;
/* 022 */   private boolean smj_isNull10;
/* 023 */   private UTF8String smj_value19;
/* 024 */   private boolean smj_isNull11;
/* 025 */   private UTF8String smj_value20;
/* 026 */   private boolean smj_isNull12;
/* 027 */   private int smj_value21;
/* 028 */   private int smj_value22;
/* 029 */   private boolean smj_isNull13;
/* 030 */   private double smj_value23;
/* 031 */   private boolean smj_isNull14;
/* 032 */   private double smj_value24;
/* 033 */   private int smj_value25;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 035 */   private UnsafeRow smj_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */
/* 042 */   public GeneratedIterator(Object[] references) {
/* 043 */     this.references = references;
/* 044 */   }
/* 045 */
/* 046 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 047 */     partitionIndex = index;
/* 048 */     this.inputs = inputs;
/* 049 */     smj_leftInput = inputs[0];
/* 050 */     smj_rightInput = inputs[1];
/* 051 */
/* 052 */     smj_rightRow = null;
/* 053 */
/* 054 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 055 */
/* 056 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 057 */     smj_result = new UnsafeRow(13);
/* 058 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 192);
/* 059 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 13);
/* 060 */     project_result = new UnsafeRow(9);
/* 061 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 062 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private boolean findNextInnerJoinRows(
/* 067 */     scala.collection.Iterator leftIter,
/* 068 */     scala.collection.Iterator rightIter) {
/* 069 */     smj_leftRow = null;
/* 070 */     int comp = 0;
/* 071 */     while (smj_leftRow == null) {
/* 072 */       if (!leftIter.hasNext()) return false;
/* 073 */       smj_leftRow = (InternalRow) leftIter.next();
/* 074 */
/* 075 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 076 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 077 */
/* 078 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 079 */       UTF8String smj_value1 = smj_isNull1 ? null : (smj_leftRow.getUTF8String(1));
/* 080 */
/* 081 */       boolean smj_isNull2 = smj_leftRow.isNullAt(2);
/* 082 */       UTF8String smj_value2 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(2));
/* 083 */
/* 084 */       int smj_value3 = smj_leftRow.getInt(7);
/* 085 */       if (smj_isNull || smj_isNull1 || smj_isNull2 || false) {
/* 086 */         smj_leftRow = null;
/* 087 */         continue;
/* 088 */       }
/* 089 */       if (!smj_matches.isEmpty()) {
/* 090 */         comp = 0;
/* 091 */         if (comp == 0) {
/* 092 */           comp = smj_value.compare(smj_value14);
/* 093 */         }
/* 094 */         if (comp == 0) {
/* 095 */           comp = smj_value1.compare(smj_value15);
/* 096 */         }
/* 097 */         if (comp == 0) {
/* 098 */           comp = smj_value2.compare(smj_value16);
/* 099 */         }
/* 100 */         if (comp == 0) {
/* 101 */           comp = (smj_value3 > smj_value17 ? 1 : smj_value3 < smj_value17 ? -1 : 0);
/* 102 */         }
/* 103 */
/* 104 */         if (comp == 0) {
/* 105 */           return true;
/* 106 */         }
/* 107 */         smj_matches.clear();
/* 108 */       }
/* 109 */
/* 110 */       do {
/* 111 */         if (smj_rightRow == null) {
/* 112 */           if (!rightIter.hasNext()) {
/* 113 */             smj_value14 = smj_value.clone();
/* 114 */             smj_value15 = smj_value1.clone();
/* 115 */             smj_value16 = smj_value2.clone();
/* 116 */             smj_value17 = smj_value3;
/* 117 */             return !smj_matches.isEmpty();
/* 118 */           }
/* 119 */           smj_rightRow = (InternalRow) rightIter.next();
/* 120 */
/* 121 */           boolean smj_isNull4 = smj_rightRow.isNullAt(0);
/* 122 */           UTF8String smj_value4 = smj_isNull4 ? null : (smj_rightRow.getUTF8String(0));
/* 123 */
/* 124 */           boolean smj_isNull5 = smj_rightRow.isNullAt(1);
/* 125 */           UTF8String smj_value5 = smj_isNull5 ? null : (smj_rightRow.getUTF8String(1));
/* 126 */
/* 127 */           boolean smj_isNull6 = smj_rightRow.isNullAt(2);
/* 128 */           UTF8String smj_value6 = smj_isNull6 ? null : (smj_rightRow.getUTF8String(2));
/* 129 */
/* 130 */           boolean smj_isNull7 = true;
/* 131 */           int smj_value7 = -1;
/* 132 */
/* 133 */           boolean smj_isNull8 = smj_rightRow.isNullAt(4);
/* 134 */           int smj_value8 = smj_isNull8 ? -1 : (smj_rightRow.getInt(4));
/* 135 */           if (!smj_isNull8) {
/* 136 */             smj_isNull7 = false; // resultCode could change nullability.
/* 137 */             smj_value7 = smj_value8 + 1;
/* 138 */
/* 139 */           }
/* 140 */           if (smj_isNull4 || smj_isNull5 || smj_isNull6 || smj_isNull7) {
/* 141 */             smj_rightRow = null;
/* 142 */             continue;
/* 143 */           }
/* 144 */           smj_value10 = smj_value4.clone();
/* 145 */           smj_value11 = smj_value5.clone();
/* 146 */           smj_value12 = smj_value6.clone();
/* 147 */           smj_value13 = smj_value7;
/* 148 */         }
/* 149 */
/* 150 */         comp = 0;
/* 151 */         if (comp == 0) {
/* 152 */           comp = smj_value.compare(smj_value10);
/* 153 */         }
/* 154 */         if (comp == 0) {
/* 155 */           comp = smj_value1.compare(smj_value11);
/* 156 */         }
/* 157 */         if (comp == 0) {
/* 158 */           comp = smj_value2.compare(smj_value12);
/* 159 */         }
/* 160 */         if (comp == 0) {
/* 161 */           comp = (smj_value3 > smj_value13 ? 1 : smj_value3 < smj_value13 ? -1 : 0);
/* 162 */         }
/* 163 */
/* 164 */         if (comp > 0) {
/* 165 */           smj_rightRow = null;
/* 166 */         } else if (comp < 0) {
/* 167 */           if (!smj_matches.isEmpty()) {
/* 168 */             smj_value14 = smj_value.clone();
/* 169 */             smj_value15 = smj_value1.clone();
/* 170 */             smj_value16 = smj_value2.clone();
/* 171 */             smj_value17 = smj_value3;
/* 172 */             return true;
/* 173 */           }
/* 174 */           smj_leftRow = null;
/* 175 */         } else {
/* 176 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 177 */           smj_rightRow = null;;
/* 178 */         }
/* 179 */       } while (smj_leftRow != null);
/* 180 */     }
/* 181 */     return false; // unreachable
/* 182 */   }
/* 183 */
/* 184 */   protected void processNext() throws java.io.IOException {
/* 185 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 186 */       smj_isNull10 = smj_leftRow.isNullAt(0);
/* 187 */       smj_value18 = smj_isNull10 ? null : (smj_leftRow.getUTF8String(0));
/* 188 */       smj_isNull11 = smj_leftRow.isNullAt(1);
/* 189 */       smj_value19 = smj_isNull11 ? null : (smj_leftRow.getUTF8String(1));
/* 190 */       smj_isNull12 = smj_leftRow.isNullAt(2);
/* 191 */       smj_value20 = smj_isNull12 ? null : (smj_leftRow.getUTF8String(2));
/* 192 */       smj_value21 = smj_leftRow.getInt(3);
/* 193 */       smj_isNull13 = smj_leftRow.isNullAt(4);
/* 194 */       smj_value22 = smj_isNull13 ? -1 : (smj_leftRow.getInt(4));
/* 195 */       smj_isNull14 = smj_leftRow.isNullAt(5);
/* 196 */       smj_value23 = smj_isNull14 ? -1.0 : (smj_leftRow.getDouble(5));
/* 197 */       smj_value24 = smj_leftRow.getDouble(6);
/* 198 */       smj_value25 = smj_leftRow.getInt(7);
/* 199 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 200 */       while (smj_iterator.hasNext()) {
/* 201 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 202 */
/* 203 */         smj_numOutputRows.add(1);
/* 204 */
/* 205 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(3);
/* 206 */         double smj_value29 = smj_isNull18 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 207 */         project_holder.reset();
/* 208 */
/* 209 */         project_rowWriter.zeroOutNullBytes();
/* 210 */
/* 211 */         if (smj_isNull10) {
/* 212 */           project_rowWriter.setNullAt(0);
/* 213 */         } else {
/* 214 */           project_rowWriter.write(0, smj_value18);
/* 215 */         }
/* 216 */
/* 217 */         if (smj_isNull11) {
/* 218 */           project_rowWriter.setNullAt(1);
/* 219 */         } else {
/* 220 */           project_rowWriter.write(1, smj_value19);
/* 221 */         }
/* 222 */
/* 223 */         if (smj_isNull12) {
/* 224 */           project_rowWriter.setNullAt(2);
/* 225 */         } else {
/* 226 */           project_rowWriter.write(2, smj_value20);
/* 227 */         }
/* 228 */
/* 229 */         project_rowWriter.write(3, smj_value21);
/* 230 */
/* 231 */         if (smj_isNull13) {
/* 232 */           project_rowWriter.setNullAt(4);
/* 233 */         } else {
/* 234 */           project_rowWriter.write(4, smj_value22);
/* 235 */         }
/* 236 */
/* 237 */         if (smj_isNull14) {
/* 238 */           project_rowWriter.setNullAt(5);
/* 239 */         } else {
/* 240 */           project_rowWriter.write(5, smj_value23);
/* 241 */         }
/* 242 */
/* 243 */         project_rowWriter.write(6, smj_value24);
/* 244 */
/* 245 */         project_rowWriter.write(7, smj_value25);
/* 246 */
/* 247 */         if (smj_isNull18) {
/* 248 */           project_rowWriter.setNullAt(8);
/* 249 */         } else {
/* 250 */           project_rowWriter.write(8, smj_value29);
/* 251 */         }
/* 252 */         project_result.setTotalSize(project_holder.totalSize());
/* 253 */         append(project_result.copy());
/* 254 */
/* 255 */       }
/* 256 */       if (shouldStop()) return;
/* 257 */     }
/* 258 */   }
/* 259 */ }
