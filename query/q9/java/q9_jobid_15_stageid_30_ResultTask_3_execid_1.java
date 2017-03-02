/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private UnsafeRow scan_result;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 019 */   private UnsafeRow filter_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 022 */   private UnsafeRow project_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     scan_input = inputs[0];
/* 034 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 035 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 036 */     scan_scanTime1 = 0;
/* 037 */     scan_batch = null;
/* 038 */     scan_batchIdx = 0;
/* 039 */     scan_colInstance0 = null;
/* 040 */     scan_result = new UnsafeRow(1);
/* 041 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 042 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 1);
/* 043 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 044 */     filter_result = new UnsafeRow(1);
/* 045 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 046 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 1);
/* 047 */     project_result = new UnsafeRow(5);
/* 048 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 049 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private void scan_nextBatch() throws java.io.IOException {
/* 054 */     long getBatchStart = System.nanoTime();
/* 055 */     if (scan_input.hasNext()) {
/* 056 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 057 */       scan_numOutputRows.add(scan_batch.numRows());
/* 058 */       scan_batchIdx = 0;
/* 059 */       scan_colInstance0 = scan_batch.column(0);
/* 060 */
/* 061 */     }
/* 062 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 063 */   }
/* 064 */
/* 065 */   protected void processNext() throws java.io.IOException {
/* 066 */     if (scan_batch == null) {
/* 067 */       scan_nextBatch();
/* 068 */     }
/* 069 */     while (scan_batch != null) {
/* 070 */       int numRows = scan_batch.numRows();
/* 071 */       while (scan_batchIdx < numRows) {
/* 072 */         int scan_rowIdx = scan_batchIdx++;
/* 073 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 074 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 075 */
/* 076 */         if (!(!(scan_isNull))) continue;
/* 077 */
/* 078 */         boolean filter_isNull2 = false;
/* 079 */
/* 080 */         boolean filter_value2 = false;
/* 081 */         filter_value2 = scan_value == 1;
/* 082 */         if (!filter_value2) continue;
/* 083 */
/* 084 */         filter_numOutputRows.add(1);
/* 085 */
/* 086 */         boolean project_isNull = true;
/* 087 */         double project_value = -1.0;
/* 088 */
/* 089 */         boolean project_isNull1 = true;
/* 090 */         boolean project_value1 = false;
/* 091 */
/* 092 */         if (!false) {
/* 093 */           project_isNull1 = false; // resultCode could change nullability.
/* 094 */           project_value1 = 0L > 1000000L;
/* 095 */
/* 096 */         }
/* 097 */         if (!project_isNull1 && project_value1) {
/* 098 */           final double project_value4 = -1.0;
/* 099 */           project_isNull = true;
/* 100 */           project_value = project_value4;
/* 101 */         }
/* 102 */
/* 103 */         else {
/* 104 */           final double project_value5 = -1.0;
/* 105 */           project_isNull = true;
/* 106 */           project_value = project_value5;
/* 107 */         }
/* 108 */         boolean project_isNull6 = true;
/* 109 */         double project_value6 = -1.0;
/* 110 */
/* 111 */         boolean project_isNull7 = true;
/* 112 */         boolean project_value7 = false;
/* 113 */
/* 114 */         if (!false) {
/* 115 */           project_isNull7 = false; // resultCode could change nullability.
/* 116 */           project_value7 = 0L > 1000000L;
/* 117 */
/* 118 */         }
/* 119 */         if (!project_isNull7 && project_value7) {
/* 120 */           final double project_value10 = -1.0;
/* 121 */           project_isNull6 = true;
/* 122 */           project_value6 = project_value10;
/* 123 */         }
/* 124 */
/* 125 */         else {
/* 126 */           final double project_value11 = -1.0;
/* 127 */           project_isNull6 = true;
/* 128 */           project_value6 = project_value11;
/* 129 */         }
/* 130 */         boolean project_isNull12 = true;
/* 131 */         double project_value12 = -1.0;
/* 132 */
/* 133 */         boolean project_isNull13 = true;
/* 134 */         boolean project_value13 = false;
/* 135 */
/* 136 */         if (!false) {
/* 137 */           project_isNull13 = false; // resultCode could change nullability.
/* 138 */           project_value13 = 0L > 1000000L;
/* 139 */
/* 140 */         }
/* 141 */         if (!project_isNull13 && project_value13) {
/* 142 */           final double project_value16 = -1.0;
/* 143 */           project_isNull12 = true;
/* 144 */           project_value12 = project_value16;
/* 145 */         }
/* 146 */
/* 147 */         else {
/* 148 */           final double project_value17 = -1.0;
/* 149 */           project_isNull12 = true;
/* 150 */           project_value12 = project_value17;
/* 151 */         }
/* 152 */         boolean project_isNull18 = true;
/* 153 */         double project_value18 = -1.0;
/* 154 */
/* 155 */         boolean project_isNull19 = true;
/* 156 */         boolean project_value19 = false;
/* 157 */
/* 158 */         if (!false) {
/* 159 */           project_isNull19 = false; // resultCode could change nullability.
/* 160 */           project_value19 = 0L > 1000000L;
/* 161 */
/* 162 */         }
/* 163 */         if (!project_isNull19 && project_value19) {
/* 164 */           final double project_value22 = -1.0;
/* 165 */           project_isNull18 = true;
/* 166 */           project_value18 = project_value22;
/* 167 */         }
/* 168 */
/* 169 */         else {
/* 170 */           final double project_value23 = -1.0;
/* 171 */           project_isNull18 = true;
/* 172 */           project_value18 = project_value23;
/* 173 */         }
/* 174 */         boolean project_isNull24 = true;
/* 175 */         double project_value24 = -1.0;
/* 176 */
/* 177 */         boolean project_isNull25 = true;
/* 178 */         boolean project_value25 = false;
/* 179 */
/* 180 */         if (!false) {
/* 181 */           project_isNull25 = false; // resultCode could change nullability.
/* 182 */           project_value25 = 0L > 1000000L;
/* 183 */
/* 184 */         }
/* 185 */         if (!project_isNull25 && project_value25) {
/* 186 */           final double project_value28 = -1.0;
/* 187 */           project_isNull24 = true;
/* 188 */           project_value24 = project_value28;
/* 189 */         }
/* 190 */
/* 191 */         else {
/* 192 */           final double project_value29 = -1.0;
/* 193 */           project_isNull24 = true;
/* 194 */           project_value24 = project_value29;
/* 195 */         }
/* 196 */         project_rowWriter.zeroOutNullBytes();
/* 197 */
/* 198 */         if (project_isNull) {
/* 199 */           project_rowWriter.setNullAt(0);
/* 200 */         } else {
/* 201 */           project_rowWriter.write(0, project_value);
/* 202 */         }
/* 203 */
/* 204 */         if (project_isNull6) {
/* 205 */           project_rowWriter.setNullAt(1);
/* 206 */         } else {
/* 207 */           project_rowWriter.write(1, project_value6);
/* 208 */         }
/* 209 */
/* 210 */         if (project_isNull12) {
/* 211 */           project_rowWriter.setNullAt(2);
/* 212 */         } else {
/* 213 */           project_rowWriter.write(2, project_value12);
/* 214 */         }
/* 215 */
/* 216 */         if (project_isNull18) {
/* 217 */           project_rowWriter.setNullAt(3);
/* 218 */         } else {
/* 219 */           project_rowWriter.write(3, project_value18);
/* 220 */         }
/* 221 */
/* 222 */         if (project_isNull24) {
/* 223 */           project_rowWriter.setNullAt(4);
/* 224 */         } else {
/* 225 */           project_rowWriter.write(4, project_value24);
/* 226 */         }
/* 227 */         append(project_result);
/* 228 */         if (shouldStop()) return;
/* 229 */       }
/* 230 */       scan_batch = null;
/* 231 */       scan_nextBatch();
/* 232 */     }
/* 233 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 234 */     scan_scanTime1 = 0;
/* 235 */   }
/* 236 */ }
