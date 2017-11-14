/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificMutableProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificMutableProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private boolean isNull15;
/* 010 */   private boolean value15;
/* 011 */   private boolean isNull16;
/* 012 */   private int value16;
/* 013 */   private boolean isNull17;
/* 014 */   private int value17;
/* 015 */   private int value_0;
/* 016 */   private int value_1;
/* 017 */   private boolean isNull_2;
/* 018 */   private int value_2;
/* 019 */   private boolean isNull_3;
/* 020 */   private int value_3;
/* 021 */
/* 022 */   public SpecificMutableProjection(Object[] references) {
/* 023 */     this.references = references;
/* 024 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(4);
/* 025 */     isNull15 = false;
/* 026 */     value15 = false;
/* 027 */     isNull16 = false;
/* 028 */     value16 = -1;
/* 029 */     isNull17 = false;
/* 030 */     value17 = -1;
/* 031 */     this.value_0 = -1;
/* 032 */     this.value_1 = -1;
/* 033 */     this.isNull_2 = true;
/* 034 */     this.value_2 = -1;
/* 035 */     this.isNull_3 = true;
/* 036 */     this.value_3 = -1;
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   public void initialize(int partitionIndex) {
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */
/* 045 */   private void evalIfTrueExpr(InternalRow i) {
/* 046 */     int value13 = i.getInt(0);
/* 047 */     isNull16 = false;
/* 048 */     value16 = value13;
/* 049 */   }
/* 050 */
/* 051 */
/* 052 */   private void evalIfCondExpr(InternalRow i) {
/* 053 */     boolean isNull4 = i.isNullAt(8);
/* 054 */     int value4 = isNull4 ? -1 : (i.getInt(8));
/* 055 */     boolean isNull5 = i.isNullAt(2);
/* 056 */     int value5 = isNull5 ? -1 : (i.getInt(2));
/* 057 */     boolean value3 = (isNull4 && isNull5) ||
/* 058 */     (!isNull4 && !isNull5 && value4 == value5);
/* 059 */     boolean value2 = false;
/* 060 */
/* 061 */     if (value3) {
/* 062 */
/* 063 */       boolean isNull7 = i.isNullAt(9);
/* 064 */       int value7 = isNull7 ? -1 : (i.getInt(9));
/* 065 */       boolean isNull8 = i.isNullAt(3);
/* 066 */       int value8 = isNull8 ? -1 : (i.getInt(3));
/* 067 */       boolean value6 = (isNull7 && isNull8) ||
/* 068 */       (!isNull7 && !isNull8 && value7 == value8);
/* 069 */       value2 = value6;
/* 070 */     }
/* 071 */     boolean value1 = false;
/* 072 */
/* 073 */     if (value2) {
/* 074 */
/* 075 */       boolean isNull9 = false;
/* 076 */
/* 077 */       boolean isNull10 = false;
/* 078 */
/* 079 */       int value11 = i.getInt(0);
/* 080 */
/* 081 */       boolean value10 = false;
/* 082 */       value10 = value11 == 0;
/* 083 */       boolean value9 = false;
/* 084 */       value9 = !(value10);
/* 085 */       value1 = value9;
/* 086 */     }
/* 087 */     isNull15 = false;
/* 088 */     value15 = value1;
/* 089 */   }
/* 090 */
/* 091 */
/* 092 */   private void evalIfFalseExpr(InternalRow i) {
/* 093 */     int value14 = i.getInt(1);
/* 094 */     isNull17 = false;
/* 095 */     value17 = value14;
/* 096 */   }
/* 097 */
/* 098 */
/* 099 */   public org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection target(InternalRow row) {
/* 100 */     mutableRow = row;
/* 101 */     return this;
/* 102 */   }
/* 103 */
/* 104 */   /* Provide immutable access to the last projected row. */
/* 105 */   public InternalRow currentValue() {
/* 106 */     return (InternalRow) mutableRow;
/* 107 */   }
/* 108 */
/* 109 */   public java.lang.Object apply(java.lang.Object _i) {
/* 110 */     InternalRow i = (InternalRow) _i;
/* 111 */
/* 112 */
/* 113 */
/* 114 */     evalIfCondExpr(i);
/* 115 */     boolean isNull = false;
/* 116 */     int value = -1;
/* 117 */     if (!isNull15 && value15) {
/* 118 */       evalIfTrueExpr(i);
/* 119 */       isNull = isNull16;
/* 120 */       value = value16;
/* 121 */     } else {
/* 122 */       evalIfFalseExpr(i);
/* 123 */       isNull = isNull17;
/* 124 */       value = value17;
/* 125 */     }
/* 126 */     this.value_0 = value;
/* 127 */
/* 128 */
/* 129 */     boolean isNull18 = false;
/* 130 */
/* 131 */     int value19 = i.getInt(1);
/* 132 */
/* 133 */     int value18 = -1;
/* 134 */     value18 = value19 + 1;
/* 135 */     this.value_1 = value18;
/* 136 */
/* 137 */
/* 138 */     boolean isNull21 = i.isNullAt(8);
/* 139 */     int value21 = isNull21 ? -1 : (i.getInt(8));
/* 140 */     this.isNull_2 = isNull21;
/* 141 */     this.value_2 = value21;
/* 142 */
/* 143 */
/* 144 */     boolean isNull22 = i.isNullAt(9);
/* 145 */     int value22 = isNull22 ? -1 : (i.getInt(9));
/* 146 */     this.isNull_3 = isNull22;
/* 147 */     this.value_3 = value22;
/* 148 */
/* 149 */     // copy all the results into MutableRow
/* 150 */     mutableRow.setInt(0, this.value_0);mutableRow.setInt(1, this.value_1);
/* 151 */     if (!this.isNull_2) {
/* 152 */       mutableRow.setInt(2, this.value_2);
/* 153 */     } else {
/* 154 */       mutableRow.setNullAt(2);
/* 155 */     }
/* 156 */
/* 157 */     if (!this.isNull_3) {
/* 158 */       mutableRow.setInt(3, this.value_3);
/* 159 */     } else {
/* 160 */       mutableRow.setNullAt(3);
/* 161 */     }
/* 162 */
/* 163 */     return mutableRow;
/* 164 */   }
/* 165 */ }
